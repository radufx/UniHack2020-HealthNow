package com.example.myapplication.ui.Setari_Medic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SetariMedicViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SetariMedicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Setari profil");
    }

    public LiveData<String> getText() {
        return mText;
    }
}