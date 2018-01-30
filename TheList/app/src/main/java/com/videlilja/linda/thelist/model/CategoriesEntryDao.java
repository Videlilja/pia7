package com.videlilja.linda.thelist.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Linda on 2018-01-24.
 */
@Dao
public interface CategoriesEntryDao {

    @Insert
    void insert(CategoriesEntry...entries);

    @Query("SELECT * FROM CategoriesEntry")
    LiveData<List<CategoriesEntry>> read();

    @Update
    void update(CategoriesEntry...entries);

    @Delete
    void delete(CategoriesEntry...entries);

}
