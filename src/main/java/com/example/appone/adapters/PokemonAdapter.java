package com.example.appone.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appone.R;
import com.example.appone.entities.PokemonData;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    private List<PokemonData> data;

    public PokemonAdapter(List<PokemonData> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_inlist, parent, false);

        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        PokemonData pokemon = data.get(position);
        TextView tvNamepokemon = holder.itemView.findViewById(R.id.namepokemon);
        tvNamepokemon.setText(pokemon.name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class PokemonViewHolder extends  RecyclerView.ViewHolder {
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
