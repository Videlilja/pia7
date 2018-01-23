package com.videlilja.linda.thelist.screens.items;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.videlilja.linda.thelist.R;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, ItemActivity.class));
    }
}
