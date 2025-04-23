package com.example.appone.services;

import com.example.appone.entities.PokemonData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonService {
    @GET("/api/v2/pokemon")
    Call<List<PokemonData>>  getColors(@Query("limit") int limit, @Query("offset") int page);

}
