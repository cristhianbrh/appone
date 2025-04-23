package com.example.appone.services;

import com.example.appone.entities.PokemonDetailResponse;
import com.example.appone.entities.PokemonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PokemonService {
    @GET("/api/v2/pokemon")
    Call<PokemonResponse>  getPokemons(@Query("limit") int limit, @Query("offset") int offset);

    @GET
    Call<PokemonDetailResponse> getPokemonData(@Url String url);
}
