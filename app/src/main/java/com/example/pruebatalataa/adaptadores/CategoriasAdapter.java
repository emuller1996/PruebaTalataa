package com.example.pruebatalataa.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebatalataa.CategoriaEditar;
import com.example.pruebatalataa.DetalleAsteroide;
import com.example.pruebatalataa.R;
import com.example.pruebatalataa.modelos.Categoria;

import java.util.List;

public class CategoriasAdapter extends RecyclerView.Adapter<CategoriasAdapter.CategoriasViewHolder> {

    List<Categoria> listaCategoira;

    public CategoriasAdapter(List<Categoria> listaCategoira){
        this.listaCategoira = listaCategoira;
    }

    @NonNull
    @Override
    public CategoriasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_item, null,false);
        return new CategoriasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriasViewHolder holder, int position) {

        holder.nombre.setText(listaCategoira.get(position).getNombre());
        holder.id.setText(String.valueOf(listaCategoira.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return this.listaCategoira.size();
    }

    public class CategoriasViewHolder extends RecyclerView.ViewHolder {
        TextView nombre ,id;
        public CategoriasViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.viewCategoriaNombreItem);
            id = itemView.findViewById(R.id.viewIdCategoriaItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, CategoriaEditar.class);
                    intent.putExtra("id",String.valueOf(listaCategoira.get(getAdapterPosition()).getId()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
