package com.example.appone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appone.adapters.BasicAdapter;
import com.example.appone.clases.Color;
import com.example.appone.tertiarydata.ColorAdapter;

import java.util.ArrayList;
import java.util.List;

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

        List<Color> colorList = new ArrayList<>();
        colorList.add(new Color("Rojo", "#FF0000"));
        colorList.add(new Color("Verde", "#00FF00"));
        colorList.add(new Color("Azul", "#0000FF"));
        colorList.add(new Color("Amarillo", "#FFFF00"));
        colorList.add(new Color("Cian", "#00FFFF"));
        colorList.add(new Color("Magenta", "#FF00FF"));
        colorList.add(new Color("Naranja", "#FFA500"));
        colorList.add(new Color("Gris", "#808080"));
        colorList.add(new Color("Negro", "#000000"));
        colorList.add(new Color("Blanco", "#FFFFFF"));

        RecyclerView recycler_colors = findViewById(R.id.recycler_colors);
        recycler_colors.setLayoutManager(new LinearLayoutManager(this));
        ColorAdapter adapter = new ColorAdapter(colorList);
        recycler_colors.setAdapter(adapter);
    }
}