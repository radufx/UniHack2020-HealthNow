package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import DomeniuFireBase.MedicFireBase;
import DomeniuFireBase.PacientFireBase;
import ValidatoriFireBase.validatorMedicFireBase;
import ValidatoriFireBase.validatorPacientFireBase;
import validatori.validatorMedic;

public class Inregistrare extends AppCompatActivity {
    private Button button;
    private Switch sw;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private Boolean success = true;

    private FirebaseAuth auth;
    private DatabaseReference database;

    private DatabaseReference users;
    private DatabaseReference ref;
    private FirebaseDatabase dBase = FirebaseDatabase.getInstance();


    private DatabaseReference usersRef;



    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare);

        button = findViewById(R.id.sign_inregistrare);
        sw = findViewById(R.id.sw_pacient_medic);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                success = true;
                create_account();


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

    }

    public void onStart (){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void create_account() {


        EditText txt = (EditText) Inregistrare.this.findViewById(R.id.editTextTextEmailAddress2);
        String email = txt.getText().toString();
        txt = (EditText) Inregistrare.this.findViewById(R.id.editTextTextPassword);
        String parola = txt.getText().toString();


        Log.d(TAG, "createAccount:" + email);

        String erori = valid_input();
        Log.d(TAG, "erori" + erori);

        if (erori.length() > 0) {
            displayToast(erori);
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, parola)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (sw.isChecked() == true) {
                                creeaza_medic();
                            }
                            else{
                                creeaza_pacient();
                            }
                            Intent intent = new Intent(Inregistrare.this, ConfirmareMail.class);
                            startActivity(intent);
                            finishAffinity();
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Inregistrare.this, "Adresa de e-mail deja existenta.",
                                    Toast.LENGTH_SHORT).show();
                            EditText txt = (EditText) Inregistrare.this.findViewById(R.id.editTextTextEmailAddress2);
                            txt.setText("");
                        }
                    }
                });
    }

    public void creeaza_pacient() {
        PacientFireBase pacient = new PacientFireBase("nume", "prenume", "adresa", "data nasterii", "cnp");
        String id = get_id();
        ref = dBase.getReference();
        users = ref.child("pacient");
        Map<String, PacientFireBase> pacienti = new HashMap<>();
        pacienti.put(id, pacient);
        users.setValue(pacienti);
    }

    public void creeaza_medic (){
        MedicFireBase medic = new MedicFireBase("nume", "prenume", "cnp", "telefon");
        String id = get_id();
        ref = dBase.getReference();
        users = ref.child("medic");
        Map<String, MedicFireBase> medici = new HashMap<>();
        medici.put(id, medic);
        users.setValue(medici);
    }

    public String get_id (){
        String ans = "";
        FirebaseUser user = auth.getCurrentUser();
        ans = user.getUid();
        return ans;
    }

    private String valid_input (){

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