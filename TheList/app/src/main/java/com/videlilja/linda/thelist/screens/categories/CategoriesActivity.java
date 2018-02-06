package com.videlilja.linda.thelist.screens.categories;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.videlilja.linda.thelist.R;
import com.videlilja.linda.thelist.model.CategoriesEntry;

import java.util.List;

public class CategoriesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        CategoriesViewModel viewModel = ViewModelProviders.of(this).get(CategoriesViewModel.class);
        //Recyclerview
        RecyclerView categoryList = findViewById(R.id.category_list);
        categoryList.setLayoutManager(new LinearLayoutManager(this));
        categoryList.setAdapter(new CategoriesAdapter());
        viewModel.getCategory().observe(this, new Observer<List<CategoriesEntry>>() {
            @Override
            public void onChanged(@Nullable List<CategoriesEntry> listEntries) {

            }
        });

    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, CategoriesActivity.class));

    }

}
