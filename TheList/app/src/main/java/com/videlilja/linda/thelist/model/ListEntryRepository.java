package com.videlilja.linda.thelist.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.videlilja.linda.thelist.model.ListEntry;

import java.util.List;

/**
 * Created by lenajehart-mizander on 2018-01-29.
 */

public class ListEntryRepository {

    private ListEntryDao mListEntryDao;

    public ListEntryRepository(ListEntryDao listEntryDao) {
        mListEntryDao = listEntryDao;
    }

    public LiveData<List<ListEntry>> getAll() {
        return mListEntryDao.read();

    }


}
