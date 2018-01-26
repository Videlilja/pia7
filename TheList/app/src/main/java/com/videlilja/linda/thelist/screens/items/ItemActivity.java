package com.videlilja.linda.thelist.screens.items;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.videlilja.linda.thelist.R;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        ItemsViewModel viewModel = ViewModelProviders.of(this).get(ItemsViewModel.class);
    }

    public void start(Context context) {
        context.startActivity(new Intent(context, ItemActivity.class));

        //RecyclerView
        RecyclerView itemList = findViewById(R.id.item_list);
        itemList.setLayoutManager(new LinearLayoutManager(this));
        itemList.setAdapter(new ItemsAdapter());
    }
}
