package com.videlilja.linda.thelist.screens.categories;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.videlilja.linda.thelist.R;
import com.videlilja.linda.thelist.model.CategoriesEntry;

/**
 * Created by Linda on 2018-01-26.
 */

public class categoriesViewHolder extends RecyclerView.ViewHolder {

    private CategoriesEntry listEntry;
    private TextView categoryName;

    public categoriesViewHolder(View itemView) {
        super(itemView);

        categoryName = itemView.findViewById(R.id.category_name);
    }
    public void bind(CategoriesEntry entry){
        listEntry = entry;

        categoryName.setText(entry.getCategoryName());
    }
    public static categoriesViewHolder newInstance(ViewGroup parent){
        return new categoriesViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.category_entry_list, parent, false)
        );
    }
}
