package com.example.appone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appone.clases.Color;

public class ActivityTertiary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tertiary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Color color1 = new Color("Rojo", "#FF0000");
        Color color2 = new Color("Verde", "#00FF00");
        Color color3 = new Color("Azul", "#0000FF");
        Color color4 = new Color("Amarillo", "#FFFF00");
        Color color5 = new Color("Cian", "#00FFFF");
        Color color6 = new Color("Magenta", "#FF00FF");
        Color color7 = new Color("Naranja", "#FFA500");
        Color color8 = new Color("Gris", "#808080");
        Color color9 = new Color("Negro", "#000000");
        Color color10 = new Color("Blanco", "#FFFFFF");


        RecyclerView recycler_colors = findViewById(R.id.recycler_colors);

    }
}