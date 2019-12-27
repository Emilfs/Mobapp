package com.example.test.ui.main.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.R;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<Integer> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(R.string.month);
    }

    public LiveData<Integer> getText() {
        return mText;
    }
}