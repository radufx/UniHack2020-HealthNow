package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import DomeniuFireBase.MedicFireBase;
import domain.Medic;
import validatori.validatorMedic;

public class Inscriere extends AppCompatActivity {
    private Button button;

    private TextView text_box;

    private FirebaseAuth mAuth;
    private FirebaseAuth auth;
    private DatabaseReference database;

    private static final String TAG = "EmailPassword";

    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscriere);

        button = findViewById(R.id.inapoi_main_inscriere);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();

        text_box = findViewById(R.id.textView2);

        text_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password_reset();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Inscriere.this, MainActivity.class);
                    finishAffinity();
                    startActivity(intent);
                }
        });


        button = findViewById(R.id.log_medic_pacient);

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

    public String getPassword(){
        return this.password;
    }

    private void password_reset (){
        EditText txt = (EditText)Inscriere.this.findViewById(R.id.editTextTextPersonName);
        String email = txt.getText().toString();
        validatorMedic validator = new validatorMedic();
        String errors = validator.valid_emaill(email);

        if (errors.length() > 0){
            Toast.makeText(Inscriere.this, errors,
                    Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Inscriere.this, "Email sent.",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{
                            Toast.makeText(Inscriere.this, "Email could not be sent.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

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

                            if (user.isEmailVerified() == false){
                                Toast.makeText(Inscriere.this, "Autentificare esuata!\nAdresa de e-mail neverificata!\n",
                                        Toast.LENGTH_SHORT).show();
                                return;
                            }
                            FirebaseDatabase.getInstance().getReference().child("medic")
                                    .addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                                MedicFireBase medic = snapshot.getValue(MedicFireBase.class);
                                                if (snapshot.getKey().equals(get_id()))
                                                {
                                                    Intent intent = new Intent(Inscriere.this, PaginaStartMedic.class);
                                                    startActivity(intent);
                                                    finishAffinity();
                                                    return;
                                                }
                                            }
                                            Intent intent = new Intent(Inscriere.this, PaginaStartPacient.class);
                                            startActivity(intent);
                                            finishAffinity();
                                            return;
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }

                                    });


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

    public String get_id (){
        String ans = "";

        FirebaseUser user = auth.getCurrentUser();

        //Long tsLong = System.currentTimeMillis()/1000;

        ans = user.getUid();

        return ans;
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