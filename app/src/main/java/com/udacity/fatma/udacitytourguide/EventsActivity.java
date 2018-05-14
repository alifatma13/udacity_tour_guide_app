package com.udacity.fatma.udacitytourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EventsActivity extends AppCompatActivity {

    // Events activity consumes events Fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new EventsFragment())
                .commit();
    }
}
