package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetareMedic extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setare_medic);

        button = findViewById(R.id.inapoi_inregistrare);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetareMedic.this, Inregistrare.class);
                finish();
                startActivity(intent);
            }
        });

        button = findViewById(R.id.salvare_medic);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetareMedic.this, PaginaStartMedic.class);
                finishAffinity();
                startActivity(intent);
            }
        });
    }
}