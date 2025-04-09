package com.example.appone.clases;

public class Color {
    private String nameColor;
    private String hex;

    public Color(String nameColor, String hex) {
        this.nameColor = nameColor;
        this.hex = hex;
    }

    public String getNameColor() {
        return nameColor;
    }

    public void setNameColor(String nameColor) {
        this.nameColor = nameColor;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
