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

import validatori.validatorMedic;

public class Inscriere extends AppCompatActivity {
    private Button button;

    private FirebaseAuth mAuth;

    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscriere);

        button = findViewById(R.id.inapoi_main_inscriere);

        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Inscriere.this, MainActivity.class);
                    finishAffinity();
                    startActivity(intent);
                }
        });

        button = findViewById(R.id.log_pacient);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inscriere.this, PaginaStartPacient.class);
                finishAffinity();
                startActivity(intent);
            }
        });

        button = findViewById(R.id.log_medic);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sign_in();
            }
        });

        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    protected void onStart (){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void sign_in() {
        EditText txt = (EditText)Inscriere.this.findViewById(R.id.editTextTextPersonName);
        String email = txt.getText().toString();
        txt = (EditText)Inscriere.this.findViewById(R.id.editTextTextPassword2);
        String parola = txt.getText().toString();

        String erori = valid_input();

        if (erori.length() > 0) {
            displayToast(erori);
            txt = (EditText)Inscriere.this.findViewById(R.id.editTextTextPersonName);
            txt.setText("");
            txt = (EditText)Inscriere.this.findViewById(R.id.editTextTextPassword2);
            txt.setText("");
            return;
        }

        mAuth.signInWithEmailAndPassword(email, parola)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent =  new Intent(Inscriere.this, PaginaStartMedic.class);
                            finishAffinity();
                            startActivity(intent);
                        }
                        else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Inscriere.this, "Autentificare esuata!\nAdresa de e-mail sau parola incorecta.",
                                    Toast.LENGTH_SHORT).show();
                            EditText txt = (EditText)Inscriere.this.findViewById(R.id.editTextTextPersonName), txt2 = (EditText)Inscriere.this.findViewById(R.id.editTextTextPassword2);
                            txt.setText("");
                            txt2.setText("");
                        }
                    }
                });
    }

    private String valid_input () {
        EditText txt = (EditText)Inscriere.this.findViewById(R.id.editTextTextPersonName);
        String email = txt.getText().toString();
        txt = (EditText)Inscriere.this.findViewById(R.id.editTextTextPassword2);
        String parola = txt.getText().toString();

        validatorMedic validator = new validatorMedic();
        String errors = "";
        errors += validator.valid_emaill(email);
        errors += validator.valid_parolaa(parola);

        return errors;
    }

    public void displayToast (String mesaj){
        Toast.makeText(Inscriere.this, mesaj, Toast.LENGTH_LONG).show();
    }
}