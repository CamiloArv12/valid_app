package com.carevalo.valid_app.ui.Information;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InfoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InfoViewModel() {
    }

    public LiveData<String> getText() {
        return mText;
    }
}