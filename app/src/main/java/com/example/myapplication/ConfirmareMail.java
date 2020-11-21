package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ConfirmareMail extends AppCompatActivity {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private static final String TAG = "EmailPassword";

    private Button buton;

    private boolean not_okay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmare_mail);

        buton = findViewById(R.id.adresa_mail);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmailVerification(mAuth.getCurrentUser());
                if (not_okay != true) {
                    mAuth.signOut();
                    Intent intent = new Intent(ConfirmareMail.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void sendEmailVerification(FirebaseUser user) {
        final String email = user.getEmail();
        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ConfirmareMail.this,
                            "Verification email sent to " + email,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(TAG, "sendEmailVerification", task.getException());
                    Toast.makeText(ConfirmareMail.this,
                            "Failed to send verification email.",
                            Toast.LENGTH_SHORT).show();
                    not_okay = true;
                }
            }

        });

    }

}