package com.videlilja.linda.thelist.screens.categories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.videlilja.linda.thelist.model.CategoriesEntry;

import java.util.List;

/**
 * Created by Linda on 2018-01-24.
 */

public class CategoriesViewModel extends ViewModel {
    private MutableLiveData<List<CategoriesEntry>> category = new MutableLiveData<>();

    public LiveData<List<CategoriesEntry>> getCategory() {
        return category;
    }


    }

