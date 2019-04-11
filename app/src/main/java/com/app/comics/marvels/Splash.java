package com.app.comics.marvels;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.app.comics.marvels.ui.HomeActivity;

public class Splash extends AppCompatActivity {

    private static final int TIME_OUT = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        //
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent mIntent = new Intent(
                                getBaseContext(),
                                HomeActivity.class
                        );
                        startActivity(mIntent);
                        finish();
                    }
                },
                TIME_OUT
        );

    }
}
