package com.example.regio.fabanimation;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab_plus, fab_android;
    Animation fab_open, fab_close, fab_clockwise, fab_anticlockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_android = (FloatingActionButton) findViewById(R.id.fab_android);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fab_clockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fab_anticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);


        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabAnimation();
            }
        });
    }

    private void fabAnimation() {
        if (isOpen) {
            fab_plus.startAnimation(fab_anticlockwise);
            fab_android.startAnimation(fab_close);
            fab_android.setVisibility(View.INVISIBLE);
            fab_android.setClickable(false);


        } else {
            fab_plus.startAnimation(fab_clockwise);
            fab_android.startAnimation(fab_open);
            fab_android.setVisibility(View.VISIBLE);
            fab_android.setClickable(true);
        }

        isOpen = ! isOpen;

    }
}
