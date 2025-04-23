package com.example.appone.entities;

import com.google.gson.annotations.SerializedName;

public class PokemonData {
    //@SerializedName("name")
    public String name;

    //@SerializedName("url")
    public String url;

    public PokemonData(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
