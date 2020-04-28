package com.example.fragmentanimation;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentanimation.fragments.SplashFragment;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();

    }

    private void initFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SplashFragment()).commit();
    }
}