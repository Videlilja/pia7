package com.videlilja.linda.thelist.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Linda on 2018-01-30.
 */
@Dao
public interface ItemsEntryDao {

    @Insert
    void insert(ItemsEntry...entries);

    @Query("SELECT * FROM ItemsEntry")
    LiveData<List<ItemsEntry>> read();

    @Update
    void update(ItemsEntry...entries);

    @Delete
    void delete(ItemsEntry...entries);
}
