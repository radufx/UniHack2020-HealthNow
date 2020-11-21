package com.example.myapplication.ui.Deconectare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.PaginaStartPacient;
import com.example.myapplication.R;

public class DeconectareFragment extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View listFragment;
        Intent intent = new Intent(DeconectareFragment.this, MainActivity.class);

        listFragment = findViewById(R.id.drawer_layout);

        startActivity(intent);

    }
}