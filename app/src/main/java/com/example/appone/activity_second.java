package com.example.appone;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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
    RecyclerView rvPokemon;
    int currentPage = 1;
    List<PokemonData> data = new ArrayList<>();
    PokemonAdapter adapter;
    boolean isLoading = false, isLastPage = false;

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

        rvPokemon = findViewById(R.id.rvPokemonList);
        rvPokemon.setLayoutManager(new LinearLayoutManager(this));
        setUpRecyclerView();

        //RecyclerView rvBasic = findViewById(R.id.rvPokemonList);
        //rvBasic.setLayoutManager(new LinearLayoutManager(this));
        //PokemonAdapter adapter = new PokemonAdapter(listData);
        //rvBasic.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "ColorListActivity onResume", Toast.LENGTH_SHORT).show();

        data.clear();
        currentPage = 1;
        adapter.notifyDataSetChanged();
        loadMoreColors();
    }

    private void setUpRecyclerView() {
        adapter = new PokemonAdapter(data);
        rvPokemon.setAdapter(adapter);

        // Scroll Listener nos permite detectar cuando el usuario hace scroll y llega al final de la lista
        // para cargar más datos
        rvPokemon.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if(layoutManager == null) return;

                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0) {

                        currentPage++;
                        loadMoreColors();
                    }
                }
            }
        });
    }
    private void loadMoreColors() {
        isLoading = true;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PokemonService service = retrofit.create(PokemonService.class);
        Call<PokemonResponse> listDataCall = service.getPokemons(20, currentPage);
        listDataCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                isLoading = false;
                if (response.isSuccessful() && response.body() != null) {
                    data.addAll(response.body().getResults());
                    adapter.notifyDataSetChanged();
                } else {
                    System.out.println("Error en la respuesta: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                t.printStackTrace();
                isLoading = false;
            }
        });
    }

}