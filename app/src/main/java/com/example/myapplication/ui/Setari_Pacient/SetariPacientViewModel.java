package com.example.myapplication.ui.Setari_Pacient;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SetariPacientViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SetariPacientViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Setari profil");
    }

    public LiveData<String> getText() {
        return mText;
    }
}