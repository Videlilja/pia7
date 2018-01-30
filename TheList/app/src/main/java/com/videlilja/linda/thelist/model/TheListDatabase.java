package com.videlilja.linda.thelist.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Linda on 2018-01-24.
 */
@Database(entities = {CategoriesEntry.class}, version = 1, exportSchema = false)
public abstract class TheListDatabase extends RoomDatabase {
<<<<<<< HEAD

    public abstract ListEntryDao getListEntrydao ();



=======
    public abstract CategoriesEntryDao getListEntrydao ();
>>>>>>> da98c4bb21e1ed9f8d3f221926956811b301757f
}
