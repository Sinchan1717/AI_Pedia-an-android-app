package com.example.ai_pedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class category extends AppCompatActivity {

    private CardView text,image,video,audio,card1,design,business ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.your_color));
        }
        setContentView(R.layout.activity_category);
        text = (CardView) findViewById(R.id.c1);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(), text.class);
                startActivity(i1);
            }
        });
        image = (CardView) findViewById(R.id.c2);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(), image.class);
                startActivity(i2);
            }
        });
        video = (CardView) findViewById(R.id.c3);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(getApplicationContext(), video.class);
                startActivity(i3);
            }
        });
        audio = (CardView) findViewById(R.id.c4);
        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(getApplicationContext(), audio.class);
                startActivity(i4);
            }
        });
        card1 = findViewById(R.id.c5);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                Intent intent = new Intent(category.this, code4.class);
                startActivity(intent);
            }
        });
        design = (CardView) findViewById(R.id.c6);
        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(getApplicationContext(), design.class);
                startActivity(i6);
            }
        });
        business = (CardView) findViewById(R.id.c7);
        business .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(getApplicationContext(), business .class);
                startActivity(i7);
            }
        });
    }
}