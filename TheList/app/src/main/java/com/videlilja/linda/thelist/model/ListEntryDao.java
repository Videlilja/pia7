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
public interface ListEntryDao {

    @Insert
    void insert(ListEntry...entries);

    @Query("SELECT * FROM list_entries")
    LiveData<List<ListEntry>> read();

    @Update
    void update(ListEntry...entries);

    @Delete
    void delete(ListEntry...entries);

}
