package com.example.tareavistas;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RecyclerView.Adapter rva;

    List<Deporte> deportes = new ArrayList<Deporte>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carga el diseño activity_main.xml
        setContentView(R.layout.activity_main);

        readData();

        // 1. Inicialización de la vista
        rv = findViewById(R.id.rv);

        // 2. Configuración del LayoutManager (lista vertical)
        lm = new LinearLayoutManager(MainActivity.this);

        // 3. Creación del Adaptador (debes crear el AdapterRV)
        rva = new AdapterRV(MainActivity.this, deportes);

        // 4. Asignación al RecyclerView
        rv.setAdapter(rva);
        rv.setLayoutManager(lm);
    }

    /**
     * Carga los nombres y descripciones del XML y crea los objetos Deporte.
     * La imagen se omite por ahora (se pasa el valor 0 al constructor).
     */
    public void readData() {
        Resources res = getResources();

        // Carga los arrays de texto del XML
        CharSequence[] names = res.getStringArray(R.array.sports_name);
        CharSequence[] descriptions = res.getStringArray(R.array.sports_description);

        deportes.clear(); // Asegura que la lista esté vacía

        // Determina el límite de la iteración por el array más corto para evitar errores
        int limit = Math.min(names.length, descriptions.length);

        for (int i = 0; i < limit; i++) {
            Deporte d = new Deporte(
                    names[i].toString(),
                    descriptions[i].toString()
            );
            deportes.add(d);
        }
    }
}