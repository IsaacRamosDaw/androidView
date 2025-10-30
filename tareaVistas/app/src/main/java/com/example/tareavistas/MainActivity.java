package com.example.tareavistas;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RecyclerView.Adapter rva;

    List<Deporte> deportes = new ArrayList<Deporte>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();

        // Carga los arrays de texto del XML
        CharSequence[] names = res.getStringArray(R.array.sports_name);
        CharSequence[] descriptions = res.getStringArray(R.array.sports_description);

        for (int i = 0; i < 5; i++) {
            deportes.add(new Deporte(
                            names[i].toString(),
                            descriptions[i].toString()
                    )
            );
        }

        //Inicialización de la vista
        rv = findViewById(R.id.rv);

        //Configuración del LayoutManager
        lm = new LinearLayoutManager(MainActivity.this);

        //Creación del Adaptador
        rva = new AdapterRV(MainActivity.this, deportes);

        //Asignación al RecyclerView
        rv.setAdapter(rva);
        rv.setLayoutManager(lm);
    }
}
