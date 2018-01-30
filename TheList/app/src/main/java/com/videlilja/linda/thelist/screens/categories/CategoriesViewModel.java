package com.videlilja.linda.thelist.screens.categories;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import com.videlilja.linda.thelist.model.ListEntry;
import com.videlilja.linda.thelist.model.ListEntryRepository;
import com.videlilja.linda.thelist.model.TheListDatabase;

import java.util.List;

/**
 * Created by Linda on 2018-01-24.
 */

public class CategoriesViewModel extends AndroidViewModel {
    private MutableLiveData<List<ListEntry>> category = new MutableLiveData<>();

    private ListEntryRepository mListEntryRepository;

    public CategoriesViewModel(@NonNull final Application application) {
        super(application);


        TheListDatabase db = Room.databaseBuilder(
                application,
                TheListDatabase.class,
                "thelistdatabase.db").build();

        mListEntryRepository = new ListEntryRepository(db.getListEntrydao());

    }

    public LiveData<List<ListEntry>> getCategory() {

        return mListEntryRepository.getAll();
    }


    }

