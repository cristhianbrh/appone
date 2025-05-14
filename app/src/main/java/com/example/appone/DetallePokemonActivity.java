package com.example.appone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appone.adapters.PokemonAdapter;
import com.example.appone.adapters.PokemonSkillsAdapter;
import com.example.appone.entities.PokemonData;
import com.example.appone.entities.PokemonDetailResponse;
import com.example.appone.entities.PokemonResponse;
import com.example.appone.services.PokemonService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetallePokemonActivity extends AppCompatActivity {
    PokemonService service;
    Button btnView;
    Button btnAppend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String name = getIntent().getStringExtra("name");
        String url = getIntent().getStringExtra("url");
        btnView = findViewById(R.id.btnViewUbic);
        btnAppend = findViewById(R.id.btnAddUbi);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PokemonService.class);
        Call<PokemonDetailResponse> listDataCall = service.getPokemonData(url);

        listDataCall.enqueue(new Callback<PokemonDetailResponse>() {
            @Override
            public void onResponse(Call<PokemonDetailResponse> call, Response<PokemonDetailResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PokemonDetailResponse data = response.body();
                    ImageView img_pokemon = findViewById(R.id.img_pokemon);
                    Glide.with(DetallePokemonActivity.this)
                            .load(data.getSprites().getBackDefault())
                            .into(img_pokemon);
                    TextView txtName = findViewById(R.id.txtName);
                    txtName.setText(data.getName());

                    RecyclerView rvBasic = findViewById(R.id.rvPokemonSkillsList);
                    rvBasic.setLayoutManager(new LinearLayoutManager(DetallePokemonActivity.this));
                    List<String> skills = new ArrayList<>();

                    for (PokemonDetailResponse.AbilitySlot entry : data.getAbilities()) {
                        skills.add(entry.ability.name);
                    }
                    PokemonSkillsAdapter adapter = new PokemonSkillsAdapter(skills);
                    rvBasic.setAdapter(adapter);
                } else {
                    System.out.println("Error en la respuesta: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PokemonDetailResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        //TODO: ADDMER
        btnAppend.setOnClickListener(v -> {
            Intent intent = new Intent(DetallePokemonActivity.this, AppendUbication.class);
            intent.putExtra("name", name);
            startActivity(intent);
            //intent.putExtra("url", pokemon.url);
            //holder.itemView.getContext().startActivity(intent);
        });

    }
}