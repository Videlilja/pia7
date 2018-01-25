package com.videlilja.linda.thelist.screens.items;

import android.arch.lifecycle.ViewModel;

/**
 * Created by Linda on 2018-01-24.
 */

public class ItemsViewModel extends ViewModel {
    private String Items;

    public String getItems() {
        return Items;
    }

    public void setItems(String items) {
        Items = items;
    }
}
