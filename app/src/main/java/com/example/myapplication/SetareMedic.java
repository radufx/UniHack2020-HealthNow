package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import DomeniuFireBase.MedicFireBase;
import DomeniuFireBase.PacientFireBase;
import ValidatoriFireBase.validatorMedicFireBase;
import validatori.validatorMedic;

public class SetareMedic extends AppCompatActivity {
    private Button button;
    private String nume, prenume, telefon, cnp;

    private FirebaseAuth auth;
    private DatabaseReference database;

    private MedicFireBase medic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setare_medic);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();

        seteaza_campuri();

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

    public void seteaza_campuri (){


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                medic = snapshot.getValue(MedicFireBase.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        if (medic == null) {
            return;
        }
        EditText txt = (EditText)SetareMedic.this.findViewById(R.id.editTextTextPersonName4);
        txt.setText(medic.getNume());
        txt = (EditText)SetareMedic.this.findViewById(R.id.editTextTextPersonName5);
        txt.setText(medic.getPrenume());
        txt = (EditText)SetareMedic.this.findViewById(R.id.editTextTextPersonName6);
        txt.setText(medic.getTelefon());
        txt = (EditText)SetareMedic.this.findViewById(R.id.editTextTextPersonName10);
        txt.setText(medic.getCnp());
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
        ans = user.getUid();
        return ans;
    }

    public void displayToast (String mesaj) {
        Toast.makeText(SetareMedic.this, mesaj, Toast.LENGTH_LONG).show();
    }
}