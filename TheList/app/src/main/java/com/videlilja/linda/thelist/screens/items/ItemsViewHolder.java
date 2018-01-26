package com.videlilja.linda.thelist.screens.items;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.videlilja.linda.thelist.R;
import com.videlilja.linda.thelist.model.ListEntry;

/**
 * Created by Linda on 2018-01-26.
 */

public class ItemsViewHolder extends RecyclerView.ViewHolder {

    private ListEntry listEntry;

    private TextView itemName;

    public ItemsViewHolder(View itemView) {
        super(itemView);

        itemName = itemView.findViewById(R.id.item_name);
    }
    public void bind(ListEntry entry){
        listEntry = entry;

        itemName.setText(entry.getItemName());
    }
    public static ItemsViewHolder NewInstance(ViewGroup parent){
        return new ItemsViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_entry_list,parent, false)
        );

    }
}