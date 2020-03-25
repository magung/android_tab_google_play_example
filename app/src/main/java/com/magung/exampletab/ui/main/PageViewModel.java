package com.magung.exampletab.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            String Isi_menu = "";
            switch (input) {
                case 1:
                    Isi_menu = "HOME";
                    break;
                case 2:
                    Isi_menu = "GAMES";
                    break;
                case 3:
                    Isi_menu = "MOVIES";
                    break;
                case 4:
                    Isi_menu = "BOOKS";
                    break;
            }
            return Isi_menu;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}