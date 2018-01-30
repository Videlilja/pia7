package com.videlilja.linda.thelist.screens.categories;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

<<<<<<< HEAD
import com.videlilja.linda.thelist.model.ListEntry;
import com.videlilja.linda.thelist.model.ListEntryRepository;
import com.videlilja.linda.thelist.model.TheListDatabase;
=======
import com.videlilja.linda.thelist.model.CategoriesEntry;
>>>>>>> da98c4bb21e1ed9f8d3f221926956811b301757f

import java.util.List;

/**
 * Created by Linda on 2018-01-24.
 */

<<<<<<< HEAD
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
=======
public class CategoriesViewModel extends ViewModel {
    private MutableLiveData<List<CategoriesEntry>> category = new MutableLiveData<>();

    public LiveData<List<CategoriesEntry>> getCategory() {
        return category;
>>>>>>> da98c4bb21e1ed9f8d3f221926956811b301757f
    }


    }

