package com.example.tareavistas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.vh> {

    // Objeto que rellena un layout e inicia el viewHolder
    private final Context c;
    private final List<Deporte> deportes;

    // Constructor
    public AdapterRV(Context c, List<Deporte> deportes) {
        this.c = c;
        this.deportes = deportes;
    }

    // 1. Crea y devuelve el ViewHolder, inflando el layout de una fila (item.xml)
    @NonNull
    @Override
    public AdapterRV.vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el diseño de la fila (R.layout.item)
        View v = LayoutInflater.from(c).inflate(R.layout.item, parent, false);
        return new vh(v);
    }

    // 2. Vincula los datos del objeto Deporte a las vistas de la fila
    @Override
    public void onBindViewHolder(@NonNull AdapterRV.vh holder, final int position) {
        // Asigna el nombre del deporte
        holder.nameDeporte.setText(deportes.get(position).getName());

    }

    // 3. Devuelve el número total de elementos
    // Método del adapter
    @Override
    public int getItemCount() {
        return deportes.size();
    }

    // --- Clase Interna: ViewHolder (vh) ---
    public class vh extends RecyclerView.ViewHolder {

        TextView nameDeporte; // Solo necesitamos la referencia al nombre

        public vh(@NonNull View itemView) {
            super(itemView);

            // Encuentra el TextView por su ID en item.xml
            // Si el ID en tu item.xml.
            nameDeporte = itemView.findViewById(R.id.sportName);

            // 4. Implementación del Click para Abrir la Vista de Detalle
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAbsoluteAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        Deporte selectedDeporte = deportes.get(position);

                        // Crear Intent a la Activity DeporteSeleccionado
                        Intent intent = new Intent(c, DeporteSeleccionado.class);

                        // Pasar Nombre y Descripción (usando Getters)
                        intent.putExtra("EXTRA_NAME", selectedDeporte.getName());
                        intent.putExtra("EXTRA_DESC", selectedDeporte.getDescription());

                        c.startActivity(intent);
                    }
                }
            });
        }
    }
}