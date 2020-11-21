package com.example.myapplication.ui.Deconectare_Pacient;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.R;

public class DeconectarePacientViewModel extends ViewModel {

    private Button button;


    public DeconectarePacientViewModel() {

        button = button.findViewById(R.id.deconectare);

    }

    public LiveData<String> getText() {
        return null;
    }
}
