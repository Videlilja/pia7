package com.videlilja.linda.thelist.screens.items;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;

import com.videlilja.linda.thelist.model.ItemsEntry;
import com.videlilja.linda.thelist.model.ItemsEntryDao;
import com.videlilja.linda.thelist.model.TheListDatabase;

import java.util.List;

/**
 * Created by Linda on 2018-01-24.
 */

public class ItemsViewModel extends AndroidViewModel {

    private final ItemsEntryDao listEntryDao;

    public ItemsViewModel(Application application) {
        super(application);

        TheListDatabase db = Room.databaseBuilder(
                application,
                TheListDatabase.class,
                "thelistdatabase.db")
                .allowMainThreadQueries()
                .build();

         listEntryDao = db.getListEntrydao();
    }

    public LiveData<List<ItemsEntry>> getListItemsById(int categoryId) {
        return listEntryDao.readByCategory(categoryId);
    }
}
