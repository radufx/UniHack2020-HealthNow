package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import DomeniuFireBase.MedicFireBase;
import ValidatoriFireBase.validatorMedicFireBase;
import validatori.validatorMedic;

public class SetareMedic extends AppCompatActivity {
    private Button button;
    private String nume, prenume, telefon, cnp;

    private FirebaseAuth auth;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setare_medic);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();

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
                salveaza_campuri();
                try {
                    creeaza_medic();
                }
                catch (Exception e){
                    displayToast(e.toString());
                }
                Intent intent = new Intent(SetareMedic.this, PaginaStartMedic.class);
                finishAffinity();
                startActivity(intent);
            }
        });
    }

    public void salveaza_campuri(){
        EditText txt = (EditText)SetareMedic.this.findViewById(R.id.editTextTextPersonName4);
        this.nume = txt.getText().toString();
        txt = (EditText)SetareMedic.this.findViewById(R.id.editTextTextPersonName5);
        this.prenume = txt.getText().toString();
        txt = (EditText)SetareMedic.this.findViewById(R.id.editTextTextPersonName6);
        this.telefon = txt.getText().toString();
        txt = (EditText)SetareMedic.this.findViewById(R.id.editTextTextPersonName10);
        this.cnp = txt.getText().toString();
    }

    public void creeaza_medic () throws Exception {

        validatorMedicFireBase validatorMedic = new validatorMedicFireBase();
        validatorMedic.validate(this.nume, this.prenume, this.cnp, this.telefon);
        MedicFireBase medic = new MedicFireBase(this.nume, this.prenume, this.cnp, this.telefon);
        String id = get_id();
        database.child("medic").child(id).setValue(medic);
    }

    public String get_id (){
        String ans = "";

        FirebaseUser user = auth.getCurrentUser();

        Long tsLong = System.currentTimeMillis()/1000;

        ans = user.getUid() + " __" + tsLong.toString();

        return ans;
    }

    public void displayToast (String mesaj) {
        Toast.makeText(SetareMedic.this, mesaj, Toast.LENGTH_LONG).show();
    }
}