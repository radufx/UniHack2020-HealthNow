package com.example.myapplication.ui.Pacienti;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PacientiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PacientiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Lista pacienti");
    }

    public LiveData<String> getText() {
        return mText;
    }
}