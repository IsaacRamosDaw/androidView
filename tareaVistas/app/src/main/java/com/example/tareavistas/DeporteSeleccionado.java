package com.example.tareavistas;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeporteSeleccionado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_deporte_seleccionado);

        // Mete en una variable los datos enviados por el adapter
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            // Recuperar el Nombre y la Descripción. Viene de AdapterRV
            String name = extras.getString("EXTRA_NAME");
            String description = extras.getString("EXTRA_DESC");

            //! Los elementos del layout
            TextView nameTextView = findViewById(R.id.detail_name);
            TextView descTextView = findViewById(R.id.detail_description);

            // 3. Asignar los datos
            if (name != null) nameTextView.setText(name);
            if (description != null) descTextView.setText(description);

            Button btnVolver = findViewById(R.id.btn_volver);

            // Método volver
            btnVolver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {finish();}
            });
        }
    }
}
