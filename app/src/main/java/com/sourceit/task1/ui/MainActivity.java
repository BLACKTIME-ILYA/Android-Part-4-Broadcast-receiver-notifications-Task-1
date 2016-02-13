package com.sourceit.task1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sourceit.task1.R;
import com.sourceit.task1.utils.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.d("start activity");
    }
}