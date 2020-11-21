package com.example.myapplication.ui.Setari_Medic;

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

public class SetariMedicFragment extends Fragment {

    private SetariMedicViewModel galleryViewModel;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_setari_medic, container, false);

        Button setari_cont = (Button) view.findViewById(R.id.setari_cont2);

        setari_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ModificaCont.class);
                getActivity().finishAffinity();
                startActivity(intent);
            }
        });

        Button stergere_cont = (Button) view.findViewById(R.id.stergere_cont2);

        stergere_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = mAuth.getCurrentUser();
                user.delete();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().finishAffinity();
                startActivity(intent);
            }
        });

        return view;

    }
}