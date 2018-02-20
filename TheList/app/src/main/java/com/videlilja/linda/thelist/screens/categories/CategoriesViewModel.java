package com.videlilja.linda.thelist.screens.categories;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.videlilja.linda.thelist.model.CategoriesEntry;
import com.videlilja.linda.thelist.model.ListEntryRepository;
import com.videlilja.linda.thelist.model.TheListDatabase;

import java.util.List;

/**
 * Created by Linda on 2018-01-24.
 */

public class CategoriesViewModel extends AndroidViewModel {

    private static final String TAG = "CategoriesViewModel";
    private ListEntryRepository mListEntryRepository;

    public CategoriesViewModel(@NonNull final Application application) {
        super(application);


        TheListDatabase db = Room.databaseBuilder(
                application,
                TheListDatabase.class,
                "thelistdatabase.db")
                .allowMainThreadQueries()
                .build();

        mListEntryRepository = new ListEntryRepository(db.getCategoryEntrydao());

    }

    public LiveData <List <CategoriesEntry>> getCategory() {
        return mListEntryRepository.getAll();
    }


    public void addCategory(String categoryName) {
        Log.d(TAG, "addCategory() called with: categoryName = [" + categoryName + "]");
        CategoriesEntry entry = new CategoriesEntry();
        entry.setCategoryName(categoryName);
        mListEntryRepository.create(entry);
    }


    public void removeItem(CategoriesEntry listEntry) {
        mListEntryRepository.delete(listEntry);
    }
}