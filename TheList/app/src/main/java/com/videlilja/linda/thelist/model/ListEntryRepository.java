package com.videlilja.linda.thelist.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.videlilja.linda.thelist.model.CategoriesEntry;

import java.util.List;

/**
 * Created by lenajehart-mizander on 2018-01-29.
 */

public class ListEntryRepository {

    private CategoriesEntryDao mListEntryDao;

    public ListEntryRepository(CategoriesEntryDao listEntryDao) {
        mListEntryDao = listEntryDao;
    }

    public LiveData<List<CategoriesEntry>> getAll() {
        return mListEntryDao.read();

    }


}
