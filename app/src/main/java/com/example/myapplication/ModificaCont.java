package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModificaCont extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_cont);

        button = findViewById(R.id.salvare_cont);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModificaCont.this, Inscriere.class);
                finish();
                startActivity(intent);
            }
        });

        button = findViewById(R.id.inapoi_modifica_cont);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModificaCont.this, PaginaStartMedic.class);
                finish();
                startActivity(intent);
            }
        });
    }
}