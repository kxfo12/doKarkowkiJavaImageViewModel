package com.example.dokarkowki;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ImageViewModel extends ViewModel {
    private MutableLiveData<Integer> current;

    public MutableLiveData<Integer> getCurrent() {
        create();
        return current;
    }

    public void setCurrent(MutableLiveData<Integer> current) {
        create();

        this.current = current;
    }
    public int takeCurrent(){
        create();
        return current.getValue();
    }
    public void setCurrent(int value){
        create();
        current.setValue(value);
    }
    public void increaseCurrent(){
        create();
        current.setValue(current.getValue()+1);
    }
    public void decreaseCurrent(){
        create();
        current.setValue(current.getValue()-1);
    }
    public void create(){
        if(current == null){
            current = new MutableLiveData<>();
            current.setValue(0);
        }
    }
}
