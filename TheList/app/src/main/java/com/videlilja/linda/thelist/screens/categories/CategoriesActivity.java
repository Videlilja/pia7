package com.videlilja.linda.thelist.screens.categories;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.videlilja.linda.thelist.R;
import com.videlilja.linda.thelist.model.ListEntry;

import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        CategoriesViewModel viewModel = ViewModelProviders.of(this).get(CategoriesViewModel.class);

        viewModel.getCategory().observe(this, new Observer<List<ListEntry>>() {
            @Override
            public void onChanged(@Nullable List<ListEntry> listEntries) {

            }
        });
    }

    public static void start(Context context){
        context.startActivity(new Intent(context,CategoriesActivity.class));

    }
}
