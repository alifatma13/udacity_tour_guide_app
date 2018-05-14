package com.udacity.fatma.udacitytourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HistoricalHeritageActivity extends AppCompatActivity {

    // Historical Heritage activity consumes the historical heritage fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction().
                replace(R.id.container, new HistoricalHeritageFragment())
                .commit();
    }
}
