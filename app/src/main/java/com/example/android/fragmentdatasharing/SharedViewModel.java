package com.example.android.fragmentdatasharing;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private MutableLiveData<String> name;

    public void setNameData(String nameData) {
        name.setValue(nameData);

/*
        If you are calling setNameData from a background thread use:
        name.postValue(nameData);
*/
    }

    public MutableLiveData<String> getNameData() {
        if (name == null) {
            name = new MutableLiveData<>();
        }

        return name;
    }
}
