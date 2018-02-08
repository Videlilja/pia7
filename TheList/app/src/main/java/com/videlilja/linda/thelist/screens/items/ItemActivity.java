package com.videlilja.linda.thelist.screens.items;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.videlilja.linda.thelist.R;
import com.videlilja.linda.thelist.model.ItemsEntry;

import java.util.List;

public class ItemActivity extends AppCompatActivity {

    private static final String TAG = "ItemActivity";
    private int categoryId;
    private ItemsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        categoryId = getIntent().getIntExtra("categoryId", -1);
        if(categoryId < 0){
            finish();
        }

        Log.d("CategoriesActivity", "onCreate: " + categoryId);

        viewModel = ViewModelProviders.of(this).get(ItemsViewModel.class);
        viewModel.getListItemsById(categoryId).observe(this, new Observer <List <ItemsEntry>>() {
            @Override
            public void onChanged(@Nullable List <ItemsEntry> itemsEntries) {
                Log.d(TAG, "onChanged() called with: itemsEntries = [" + itemsEntries.size() + "]");
            }
        });

        //RecyclerView
        RecyclerView itemList = findViewById(R.id.item_list);
        itemList.setLayoutManager(new LinearLayoutManager(this));
        itemList.setAdapter(new ItemsAdapter());

        findViewById(R.id.itemaddbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateDialog(v);
            }
        });
    }







    private void openCreateDialog(View v) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.item_popup, null);

        final EditText itemName = view.findViewById(R.id.editText);
        final EditText quantityName = view.findViewById(R.id.editText2);
        final Button itemButton = view.findViewById(R.id.savebuttonitem);

        dialogBuilder.setView(view);

        final AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemName.getText().toString().length() > 0)
                if (quantityName.getText().toString().length() > 0){
                    String TAG = null;
                    Log.d(TAG, "onClick: Nu klickar jag");

                    viewModel.create(
                            categoryId,
                            itemName.getText().toString(),
                            Integer.parseInt(quantityName.getText().toString())
                    );

                    // Create and save category
                    dialog.dismiss();
                }
            }
        });
    }



    public static void start(Context context, int id) {
        Intent intent = new Intent(context, ItemActivity.class);
        intent.putExtra("categoryId", id);
        context.startActivity(intent);
    }
}
