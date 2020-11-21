package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Testare.TesteRepoPacienti;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TesteRepoPacienti teste_repo = new TesteRepoPacienti();
        teste_repo.main(null);

        button = findViewById(R.id.inscriere);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Inscriere.class);
                finish();
                startActivity(intent);

            }
        });

        button = findViewById(R.id.inregistrare);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Inregistrare.class);
                finish();
                startActivity(intent);
            }
        });
    }
}