package com.example.appone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appone.models.PockemonUbic;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AppendUbication extends AppCompatActivity {
    private Button btnSave;
    private EditText inpLat, inpLong;
    private DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.append_ubication);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        inpLat = findViewById(R.id.inpLat);
        inpLong = findViewById(R.id.inpLong);
        btnSave = findViewById(R.id.btnSave);

        String pokemonName = getIntent().getStringExtra("name");
        dbRef = FirebaseDatabase.getInstance().getReference("pokemons_ubic");

        btnSave.setOnClickListener(v->{
            try {
                String locationId = dbRef.push().getKey();
                if (locationId != null) {
                    PockemonUbic location = new PockemonUbic(Double.parseDouble(inpLat.getText().toString()), Double.parseDouble(inpLong.getText().toString()));
                    dbRef.child(pokemonName).child(locationId).setValue(location)
                            .addOnSuccessListener(c -> {
                                finish();
                            })
                            .addOnFailureListener(e ->
                                    System.out.println("Upps, ocurrió un error"));
                }

            } catch (NumberFormatException e) {
                System.out.println("Los datos ingresados son incorrectos");
            }
        });
    }
}
