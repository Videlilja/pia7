package com.videlilja.linda.thelist.screens.items;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.videlilja.linda.thelist.R;
import com.videlilja.linda.thelist.model.ItemsEntry;

import java.util.List;

public class ItemActivity extends AppCompatActivity {

    private int categoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        categoryId = getIntent().getIntExtra("categoryId", -1);
        if(categoryId < 0){
            finish();
        }

        Log.d("CategoriesActivity", "onCreate: " + categoryId);

        ItemsViewModel viewModel = ViewModelProviders.of(this).get(ItemsViewModel.class);
        viewModel.getListItemsById(categoryId).observe(this, new Observer <List <ItemsEntry>>() {
            @Override
            public void onChanged(@Nullable List <ItemsEntry> itemsEntries) {

            }
        });

        //RecyclerView
        RecyclerView itemList = findViewById(R.id.item_list);
        itemList.setLayoutManager(new LinearLayoutManager(this));
        itemList.setAdapter(new ItemsAdapter());
    }

    public static void start(Context context, int id) {
        Intent intent = new Intent(context, ItemActivity.class);
        intent.putExtra("categoryId", id);
        context.startActivity(intent);
    }
}
