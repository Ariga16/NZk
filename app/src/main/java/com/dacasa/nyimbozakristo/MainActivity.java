package com.dacasa.nyimbozakristo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView songContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // toolbar
       // Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        songContent = findViewById(R.id.tvContentOfSong);
        Intent i = getIntent();
        String title = i.getStringExtra("title of song");
        String content = i.getStringExtra("content of song");
        // animation
        //songContent.setAnimation(AnimationUtils.loadAnimation(Nyimbo_Details.this, R.anim.fade_transition_animation));

        //set the appbar title as song title
        getSupportActionBar().setTitle(title);

        //set content of the song to textview
        songContent.setText(content);
        songContent.setMovementMethod(new ScrollingMovementMethod());
        //enable back arrow to main activity or recyclerview
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);






    }
}