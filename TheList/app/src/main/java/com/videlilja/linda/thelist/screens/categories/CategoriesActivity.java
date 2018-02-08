package com.videlilja.linda.thelist.screens.categories;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.videlilja.linda.thelist.R;
import com.videlilja.linda.thelist.model.CategoriesEntry;
import com.videlilja.linda.thelist.screens.items.ItemActivity;

import java.util.List;

public class CategoriesActivity extends AppCompatActivity {
    ListView listView;

    private static final String TAG = "CategoriesActivity";
    private CategoriesViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);


        viewModel = ViewModelProviders.of(this).get(CategoriesViewModel.class);


        RecyclerView categoryList = findViewById(R.id.category_list);
        categoryList.setLayoutManager(new LinearLayoutManager(this));
        final CategoriesAdapter adapter = new CategoriesAdapter(new categoriesViewHolder.OnCategoryClicked() {
            @Override
            public void onCategoryClicked(CategoriesEntry entry) {
                Log.d(TAG, "onCategoryClicked() called with: entry = [" + entry + "]");
                ItemActivity.start(CategoriesActivity.this, entry.getId());
            }
        });
        categoryList.setAdapter(adapter);
        viewModel.getCategory().observe(this, new Observer <List <CategoriesEntry>>() {
            @Override
            public void onChanged(@Nullable List <CategoriesEntry> listEntries) {
                Log.d(TAG, "onChanged() called with: listEntries = [" + listEntries.size() + "]");
                adapter.setCategoriesEntries(listEntries);
            }
        });

        findViewById(R.id.categoryaddbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateDialog(v);
            }
        });
    }



    private void openCreateDialog(View v) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.categories_popup, null);

        final EditText categoryName = view.findViewById(R.id.createCategories);
        final Button saveButton = view.findViewById(R.id.saveCategories);

        dialogBuilder.setView(view);

        final AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (categoryName.getText().toString().length() > 0) {
                    Log.d(TAG, "onClick: Nu klickar jag");

                    viewModel.addCategory(categoryName.getText().toString());

                    // Create and save category
                    dialog.dismiss();
                }
            }
        });
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, CategoriesActivity.class));


    }


}


