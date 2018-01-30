package com.videlilja.linda.thelist.screens.categories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.videlilja.linda.thelist.model.ListEntry;
import com.videlilja.linda.thelist.model.ListEntryRepository;

import java.util.List;

/**
 * Created by Linda on 2018-01-24.
 */

public class CategoriesViewModel extends ViewModel {
    private MutableLiveData<List<ListEntry>> category = new MutableLiveData<>();

    private ListEntryRepository mListEntryRepository;

    public CategoriesViewModel(@NonNull final Application application) {
        mListEntryRepository = new ListEntryRepository();

    }

    public LiveData<List<ListEntry>> getCategory() {

        return mListEntryRepository.getAll();
    }


    }

