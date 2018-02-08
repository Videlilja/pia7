package com.videlilja.linda.thelist.screens.categories;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.videlilja.linda.thelist.model.CategoriesEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linda on 2018-01-26.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<categoriesViewHolder> {

    private List<CategoriesEntry> categoriesEntries = new ArrayList<>();

    private categoriesViewHolder.OnCategoryClicked listener;

    public CategoriesAdapter(categoriesViewHolder.OnCategoryClicked listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return categoriesEntries.size();
    }
    @Override
    public categoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return categoriesViewHolder.newInstance(parent, listener);
    }

    @Override
    public void onBindViewHolder(categoriesViewHolder holder, int position) {
        holder.bind(categoriesEntries.get(position));
    }

    public void setCategoriesEntries(List<CategoriesEntry> categoriesEntries) {
        this.categoriesEntries = categoriesEntries;
        notifyDataSetChanged();
    }
}
