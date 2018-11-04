package com.ni3bobade.sounds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SoundsCategoryActivity extends AppCompatActivity {

    ImageView animalsImageView;
    ImageView warningsImageView;
    ImageView tauntsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sounds_category);

        animalsImageView = findViewById(R.id.animalsImageView);
        warningsImageView = findViewById(R.id.warningsImageView);
        tauntsImageView = findViewById(R.id.tauntsImageView);

        animalsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoundsCategoryActivity.this, AnimalSoundsActivity.class);
                startActivity(intent);
            }
        });

        warningsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoundsCategoryActivity.this, WarningSoundsActivity.class);
                startActivity(intent);
            }
        });

        tauntsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SoundsCategoryActivity.this, TauntsSoundsActivity.class);
                startActivity(intent);
            }
        });
    }
}
