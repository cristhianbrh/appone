package com.example.appone.entities;

import com.google.gson.annotations.SerializedName;

public class PokemonData {
    //@SerializedName("name")
    public String nombre;

    //@SerializedName("url")
    public String url;

    public PokemonData(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }
}
