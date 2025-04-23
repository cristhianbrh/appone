package com.example.appone.entities;

import java.util.List;

public class PokemonResponse {
    private List<PokemonData> results;

    public List<PokemonData> getResults() {
        return results;
    }

    public void setResults(List<PokemonData> results) {
        this.results = results;
    }
}
