package com.videlilja.linda.thelist.screens.categories;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.videlilja.linda.thelist.model.ListEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linda on 2018-01-26.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<categoriesViewHolder> {

    private List<ListEntry> ListEntryList = new ArrayList<>();


    @Override
    public int getItemCount() {
        return ListEntryList.size();
    }
    @Override
    public categoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return categoriesViewHolder.newInstance(parent);
    }

    @Override
    public void onBindViewHolder(categoriesViewHolder holder, int position) {
        holder.bind(ListEntryList.get(position));
    }

    public void setListEntryList(List<ListEntry> listEntryList) {
        ListEntryList = listEntryList;
        notifyDataSetChanged();
    }
}
