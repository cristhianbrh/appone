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
import com.example.appone.entities.PokemonResponse;
import com.example.appone.services.PokemonService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class activity_second extends AppCompatActivity {
    PokemonService service;

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(PokemonService.class);
        Call<PokemonResponse> listDataCall = service.getPokemons(20,1);
        listDataCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<PokemonData> data = response.body().getResults();

                    RecyclerView rvBasic = findViewById(R.id.rvPokemonList);
                    rvBasic.setLayoutManager(new LinearLayoutManager(activity_second.this));
                    PokemonAdapter adapter = new PokemonAdapter(data);
                    rvBasic.setAdapter(adapter);
                } else {
                    System.out.println("Error en la respuesta: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });



        //RecyclerView rvBasic = findViewById(R.id.rvPokemonList);
        //rvBasic.setLayoutManager(new LinearLayoutManager(this));
        //PokemonAdapter adapter = new PokemonAdapter(listData);
        //rvBasic.setAdapter(adapter);
    }
}