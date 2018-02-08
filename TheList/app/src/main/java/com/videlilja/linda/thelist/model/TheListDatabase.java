package com.videlilja.linda.thelist.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Linda on 2018-01-24.
 */
@Database(entities = {CategoriesEntry.class, ItemsEntryDao.class}, version = 1, exportSchema = false)
public abstract class TheListDatabase extends RoomDatabase {

    public abstract CategoriesEntryDao getCategoryEntrydao();

    public abstract ItemsEntryDao getListEntrydao();

}
