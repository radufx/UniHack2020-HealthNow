package com.example.myapplication.ui.Simptome;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SimptomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SimptomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Lista simptome");
    }

    public LiveData<String> getText() {
        return mText;
    }
}