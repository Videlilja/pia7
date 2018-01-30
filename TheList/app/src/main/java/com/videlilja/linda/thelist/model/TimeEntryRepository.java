package com.videlilja.linda.thelist.screens.categories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.videlilja.linda.thelist.model.ListEntry;

import java.util.List;

/**
 * Created by lenajehart-mizander on 2018-01-29.
 */

public class TimeEntryRepository {

    private MutableLiveData<List<ListEntry>> entries; = new MutableLiveData<>()

    public LiveData<List<ListEntry>> getAll() {
        return entries;

    }


}
