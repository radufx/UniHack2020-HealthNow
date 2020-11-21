package com.example.myapplication.ui.Deconectare_Medic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DeconectareMedicViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DeconectareMedicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Deconectare");
    }

    public LiveData<String> getText() {
        return mText;
    }
}