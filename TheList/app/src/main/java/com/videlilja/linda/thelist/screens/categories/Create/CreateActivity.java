package com.videlilja.linda.thelist.screens.categories.Create;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.videlilja.linda.thelist.R;
import com.videlilja.linda.thelist.screens.categories.CategoriesActivity;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.categories_popup);

    }

    public static void start(Context context){

        context.startActivity(new Intent(context, CreateActivity.class));



    }
}
