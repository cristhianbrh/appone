package com.example.appone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appone.adapters.PokemonAdapter;
import com.example.appone.entities.PokemonData;

import java.util.ArrayList;
import java.util.List;


public class activity_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<PokemonData> data = new ArrayList<>();
        data.add(new PokemonData("name", "dasdadsa"));


        RecyclerView rvBasic = findViewById(R.id.rvPokemonList);
        rvBasic.setLayoutManager(new LinearLayoutManager(this));
        PokemonAdapter adapter = new PokemonAdapter(data);
        rvBasic.setAdapter(adapter);
    }
}