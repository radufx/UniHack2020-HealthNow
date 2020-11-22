package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;

import DomeniuFireBase.PacientFireBase;
import ValidatoriFireBase.validatorPacientFireBase;


public class SetareProfil extends AppCompatActivity {
    private Button button1;
    private Calendar calendar;
    private DatePickerDialog datePick;
    private TextView text;

    private PacientFireBase pacient;

    private String nume, prenume, adresa, data_nasterii, cnp;

    private FirebaseAuth auth;
    private DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();

        seteaza_campuri();

        setContentView(R.layout.activity_setare_profil);

        button1 = findViewById(R.id.inapoi_inregistrare);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetareProfil.this, Inregistrare.class);
                finish();
                startActivity(intent);
            }
        });

        button1 = findViewById(R.id.salvare_profil);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetareProfil.this, PaginaStartPacient.class);
                if (!validate_input()){

                    return;
                }
                finishAffinity();
                startActivity(intent);
            }
        });

        button1 = findViewById(R.id.alege);
        text = findViewById(R.id.editTextDate);

        calendar = Calendar.getInstance();
        datePick = new DatePickerDialog(SetareProfil.this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datePick = new DatePickerDialog(SetareProfil.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int pyear, int pmonth, int pday) {
                        String sday = Integer.toString(pday);
                        String smonth = Integer.toString(pmonth+1);
                        String syear = Integer.toString(pyear);
                        text.setText(sday + "/" + smonth + "/" + syear);
                    }
                }, day, month, year);
                datePick.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
                datePick.show();
            }
        });
    }

    public void seteaza_campuri (){

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pacient = snapshot.getValue(PacientFireBase.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        if (pacient == null){
            return;
        }
        EditText txt = (EditText)SetareProfil.this.findViewById(R.id.editTextTextPersonName7);
        txt.setText(pacient.getNume());
        txt = (EditText)SetareProfil.this.findViewById(R.id.editTextTextPersonName12);
        txt.setText(pacient.getPrenume());
        txt = (EditText)SetareProfil.this.findViewById(R.id.editTextTextPersonName9);
        txt.setText(pacient.getAdresa());
        txt = (EditText)SetareProfil.this.findViewById(R.id.editTextDate);
        txt.setText(pacient.getData_nasterii());
        txt = (EditText)SetareProfil.this.findViewById(R.id.editTextTextPersonName13);
        txt.setText(pacient.getCnp());
    }

    public void salveaza_campuri(){
        EditText txt = (EditText)SetareProfil.this.findViewById(R.id.editTextTextPersonName7);
        this.nume = txt.getText().toString();
        txt = (EditText)SetareProfil.this.findViewById(R.id.editTextTextPersonName12);
        this.prenume = txt.getText().toString();
        txt = (EditText)SetareProfil.this.findViewById(R.id.editTextTextPersonName9);
        this.adresa = txt.getText().toString();
        txt = (EditText)SetareProfil.this.findViewById(R.id.editTextDate);
        this.data_nasterii = txt.getText().toString();
        txt = (EditText)SetareProfil.this.findViewById(R.id.editTextTextPersonName13);
        this.cnp = txt.getText().toString();
    }

    public void creeaza_pacient() throws Exception {
        validatorPacientFireBase validatorPacient = new validatorPacientFireBase();
        validatorPacient.validate(this.nume, this.prenume, this.adresa, this.cnp);
        PacientFireBase pacient = new PacientFireBase(this.nume, this.prenume, this.adresa, this.data_nasterii, this.cnp);
        String id = get_id();
        database.child("pacient").child(id).setValue(pacient);
    }

    public String get_id() {
        String ans = "";
        FirebaseUser user = auth.getCurrentUser();
        ans = user.getUid();
        return ans;
    }

    public boolean validate_input (){
        boolean valid = true;
        return valid;
    }

    public void displayToast (String mesaj){
        Toast.makeText(SetareProfil.this, mesaj, Toast.LENGTH_LONG).show();
    }

}