package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class SetareProfil extends AppCompatActivity {
    private Button button1;
    private Calendar calendar;
    private DatePickerDialog datePick;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                finishAffinity();
                startActivity(intent);
            }
        });

        button1 = findViewById(R.id.alege);
        text = findViewById(R.id.editTextDate);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
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
                datePick.show();
            }
        });
    }

}