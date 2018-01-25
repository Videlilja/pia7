package com.videlilja.linda.thelist.screens.splash;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.videlilja.linda.thelist.R;
import com.videlilja.linda.thelist.screens.categories.CategoriesActivity;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        CategoriesActivity.start(this);

        SplashViewModel viewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, SplashActivity.class));
    }
}
