package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.BreakIterator;

import validatori.validatorMedic;

public class Inregistrare extends AppCompatActivity {
    private Button button;
    private Switch sw;
    private FirebaseAuth mAuth;

    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare);

        button = findViewById(R.id.sign_inregistrare);
        sw = findViewById(R.id.sw_pacient_medic);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sw.isChecked() == true) {
                    create_account_medic();
                    Intent intent = new Intent(Inregistrare.this, SetareMedic.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Inregistrare.this, SetareProfil.class);
                    startActivity(intent);
                }

            }
        });


        button = findViewById(R.id.inapoi_main_inregistrare);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inregistrare.this, MainActivity.class);
                finishAffinity();
                startActivity(intent);
            }
        });
        mAuth = FirebaseAuth.getInstance();

    }

    public void onStart (){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void create_account_medic (){
        EditText txt = (EditText)Inregistrare.this.findViewById(R.id.editTextTextEmailAddress2);
        String email = txt.getText().toString();
        txt = (EditText)Inregistrare.this.findViewById(R.id.editTextTextPassword);
        String parola = txt.getText().toString();


        Log.d(TAG, "createAccount:" + email);

        String erori = valid_input();

        if (erori.length() > 0){
            displayToast(erori);
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, parola)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Inregistrare.this, "Adresa de e-mail deja existenta.",
                                    Toast.LENGTH_SHORT).show();
                            EditText txt = (EditText)Inregistrare.this.findViewById(R.id.editTextTextEmailAddress2);
                            txt.setText("");
                            return;
                            //updateUI(null);
                        }

                        // ...
                    }
                });

        Intent intent = new Intent(Inregistrare.this, SetareMedic.class);
        startActivity(intent);


    }

    private void create_account_pacient (String email, String parola){

    }

    private String valid_input (){
        boolean valid = true;

        EditText txt = (EditText)Inregistrare.this.findViewById(R.id.editTextTextEmailAddress2);
        String email = txt.getText().toString();
        txt = (EditText)Inregistrare.this.findViewById(R.id.editTextTextPassword3);
        String confirmare_parola = txt.getText().toString();
        txt = (EditText)Inregistrare.this.findViewById(R.id.editTextTextPassword);
        String parola = txt.getText().toString();
        txt = (EditText)Inregistrare.this.findViewById(R.id.editTextTextPersonName2);
        String username = txt.getText().toString();

        validatorMedic validator = new validatorMedic();
        String errors = "";
        errors += validator.valid_usernamee(username);
        errors += validator.valid_emaill(email);
        errors += validator.valid_parolaa(parola);

        if (!parola.equals(confirmare_parola)) errors += "Parolele nu coincid!\n";

        return errors;
    }


    public void displayToast (String mesaj){
        Toast.makeText(Inregistrare.this, mesaj, Toast.LENGTH_LONG).show();
    }
}