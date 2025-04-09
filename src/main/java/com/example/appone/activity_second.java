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
import com.example.appone.clases.Contact;

import java.util.ArrayList;
import java.util.List;


public class activity_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Contact> data = new ArrayList<Contact>();
        data.add(new Contact("Cristhian Alexander Bautista Ruiz", "92129321"));
        data.add(new Contact("Addmer Local Lol Ruiz", "943656546"));

        data.add(new Contact("María Flor Ruiz Julca", "92312443"));

        data.add(new Contact("Lopdsad Alejandro Ruiz", "9253543"));

        data.add(new Contact("Alex Alexander Bautista Ruiz", "9867764"));

        RecyclerView rvBasic = findViewById(R.id.rvBasic);
        rvBasic.setLayoutManager(new LinearLayoutManager(this));
        BasicAdapter adapter = new BasicAdapter(data);
        rvBasic.setAdapter(adapter);
    }
}