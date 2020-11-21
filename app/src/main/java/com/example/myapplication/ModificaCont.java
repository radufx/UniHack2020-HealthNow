package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ModificaCont extends AppCompatActivity {
    private Button button;
    private String parola_veche, parola_noua, parola_noua_confirmare;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    private String erori = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_cont);

        button = findViewById(R.id.salvare_cont);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eroare = valid();
                if (eroare.length() > 0){
                    Toast.makeText(ModificaCont.this, eroare,
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                modifica();
                Toast.makeText(ModificaCont.this, "Parola schimbata cu succes!",
                        Toast.LENGTH_SHORT).show();
                EditText txt;
                txt = (EditText) ModificaCont.this.findViewById(R.id.editTextTextPassword5);
                txt.setText("");
                txt = (EditText) ModificaCont.this.findViewById(R.id.editTextTextPassword6);
                txt.setText("");

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

    public String valid (){
        EditText txt;
        txt = (EditText) ModificaCont.this.findViewById(R.id.editTextTextPassword5);
        parola_noua = txt.getText().toString();
        txt = (EditText) ModificaCont.this.findViewById(R.id.editTextTextPassword6);
        parola_noua_confirmare = txt.getText().toString();


        if (parola_noua.length() == 0)
            erori += "Parola noua invalida!\n";
        if (!parola_noua.equals(parola_noua_confirmare))
            erori += "Parolele nu coincid!\n";

        return erori;
    }

    public void modifica (){
        EditText txt = (EditText) ModificaCont.this.findViewById(R.id.editTextTextPassword5);
        parola_noua = txt.getText().toString();
        user.updatePassword(parola_noua);
    }
}