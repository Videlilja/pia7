package com.videlilja.linda.thelist.screens.items;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.videlilja.linda.thelist.model.CategoriesEntry;
import com.videlilja.linda.thelist.model.ItemsEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linda on 2018-01-26.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsViewHolder> {

    private List<ItemsEntry> listEntryList = new ArrayList<>();

    @Override
    public int getItemCount() {
        return listEntryList.size();
    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ItemsViewHolder.NewInstance(parent);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        holder.bind(listEntryList.get(position));

    }

    public void setListEntryList(List<ItemsEntry> listEntryList) {
        this.listEntryList = listEntryList;
        notifyDataSetChanged();
    }
}
