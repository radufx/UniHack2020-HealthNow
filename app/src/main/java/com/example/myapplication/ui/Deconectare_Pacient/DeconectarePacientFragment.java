package com.example.myapplication.ui.Deconectare_Pacient;

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
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;

public class DeconectarePacientFragment extends Fragment {

    private DeconectarePacientViewModel homeViewModel;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_deconectare_pacient, container, false);

        Button deconectare = (Button) view.findViewById(R.id.deconectare);

        deconectare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent in = new Intent(getActivity(), MainActivity.class);
                getActivity().finishAffinity();
                startActivity(in);
            }
        });
        return view;
    }
}