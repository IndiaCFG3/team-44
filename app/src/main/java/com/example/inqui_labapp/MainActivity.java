package com.example.inqui_labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int Splash = 3000;
    Animation topanimation, bottomanim;
    ImageView imageView;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topanimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        imageView = findViewById(R.id.logoimg);
        text = findViewById(R.id.logoid);
        imageView.setAnimation(topanimation);
        text.setAnimation(bottomanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                Pair[] pair = new Pair[2];
//                pair[0] = new Pair<View, String>(imageView, "logo_image");
//                pair[1] = new Pair<View, String>(text, "logo_text");
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pair);

                startActivity(intent);

            }
        }, Splash);
    }
}