package com.videlilja.linda.thelist.screens.items;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.videlilja.linda.thelist.R;
import com.videlilja.linda.thelist.model.CategoriesEntry;
import com.videlilja.linda.thelist.model.ItemsEntry;

/**
 * Created by Linda on 2018-01-26.
 */

public class ItemsViewHolder extends RecyclerView.ViewHolder {

    private ItemsEntry listEntry;

    private TextView itemName;
    private TextView quantity;

    public ItemsViewHolder(View itemView) {
        super(itemView);

        itemName = itemView.findViewById(R.id.item_name);
        quantity = itemView.findViewById(R.id.quantity_textview);

    }
    public void bind(ItemsEntry entry){
        listEntry = entry;

        itemName.setText(entry.getItemName());

       /*if (entry.getQuantity() < 0 ) {
            quantity.setText("");

        }

        else {
            quantity.setText(Integer.toString(entry.getQuantity()));
        }*/
       quantity.setText(entry.getQuantity());
    }
    public static ItemsViewHolder NewInstance(ViewGroup parent){
        return new ItemsViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_entry_list,parent, false)
        );

    }
}
