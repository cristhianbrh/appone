package com.example.appone.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonDetailResponse {
    private String name;
    private int order;
    private List<AbilitySlot> abilities;
    private Sprites sprites;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<AbilitySlot> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilitySlot> abilities) {
        this.abilities = abilities;
    }

    public static class Sprites {
        @SerializedName("back_default")
        private String backDefault;

        public String getBackDefault() {
            return backDefault;
        }
    }
    public static class AbilitySlot {
        public Ability ability;
        public boolean is_hidden;
        public int slot;

        public AbilitySlot(Ability ability, boolean is_hidden, int slot) {
            this.ability = ability;
            this.is_hidden = is_hidden;
            this.slot = slot;
        }
    }
    public static class Ability {
        public String name;
        public String url;

        public Ability(String name, String url) {
            this.name = name;
            this.url = url;
        }
    }

}
