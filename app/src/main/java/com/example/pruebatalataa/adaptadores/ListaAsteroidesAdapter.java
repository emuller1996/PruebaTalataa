package com.example.pruebatalataa.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebatalataa.DetalleAsteroide;
import com.example.pruebatalataa.R;
import com.example.pruebatalataa.modelos.Asteroide;

import java.util.ArrayList;

public class ListaAsteroidesAdapter extends RecyclerView.Adapter<ListaAsteroidesAdapter.AsteroideViewHolder> {

    ArrayList<Asteroide> listaAsteroides;

    public ListaAsteroidesAdapter(ArrayList<Asteroide> listaAsteroides){
        this.listaAsteroides=listaAsteroides;
    }

    @NonNull
    @Override
    public AsteroideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asteriode,null,false);
        return new AsteroideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsteroideViewHolder holder, int position) {
        holder.name.setText(listaAsteroides.get(position).getName());
        holder.adsoluted.setText("Magnitud : "+Double.toString(listaAsteroides.get(position).getAbsolute_magnitude_h()));

    }

    @Override
    public int getItemCount() {
        return this.listaAsteroides.size();
    }

    public class AsteroideViewHolder extends RecyclerView.ViewHolder {
        TextView name,adsoluted;
        public AsteroideViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.viewName);
            adsoluted = itemView.findViewById(R.id.viewAbsolute);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DetalleAsteroide.class);
                    intent.putExtra("id",listaAsteroides.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
