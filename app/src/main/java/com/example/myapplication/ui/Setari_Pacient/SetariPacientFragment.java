package com.example.myapplication.ui.Setari_Pacient;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.MainActivity;
import com.example.myapplication.ModificaCont;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetariPacientFragment extends Fragment {

    private SetariPacientViewModel galleryViewModel;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_setari_pacient, container, false);
        Button setari = (Button) view.findViewById(R.id.setari_cont);
        setari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ModificaCont.class);
                getActivity().finishAffinity();
                startActivity(intent);
            }
        });

        view = inflater.inflate(R.layout.fragment_setari_pacient, container, false);
        Button stergere = (Button) view.findViewById(R.id.stergere_cont);
        stergere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = mAuth.getCurrentUser();
                DatabaseReference database = mDatabase.child("pacient").child(user.getUid());
                database.removeValue();
                user.delete();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().finishAffinity();
                startActivity(intent);
            }
        });
        return view;

    }
}