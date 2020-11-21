package com.example.myapplication.ui.Deconectare_Pacient;

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

import com.example.myapplication.R;

public class DeconectarePacientFragment extends Fragment {

    private DeconectarePacientViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(DeconectarePacientViewModel.class);
        View root = inflater.inflate(R.layout.fragment_deconectare_pacient, container, false);

        return root;

    }
}