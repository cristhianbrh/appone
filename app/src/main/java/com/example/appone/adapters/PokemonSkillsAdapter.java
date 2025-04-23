package com.example.appone.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appone.R;

import java.util.List;

public class PokemonSkillsAdapter extends RecyclerView.Adapter<PokemonSkillsAdapter.PokemonViewHolder> {
    private List<String> data;

    public PokemonSkillsAdapter(List<String> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_habs, parent, false);

        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        String skill = data.get(position);
        TextView tvSkill = holder.itemView.findViewById(R.id.txtHab);
        tvSkill.setText(skill);
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
