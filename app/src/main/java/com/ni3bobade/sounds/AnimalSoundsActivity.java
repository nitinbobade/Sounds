package com.ni3bobade.sounds;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class AnimalSoundsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private static Sounds soundsPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sounds_list_grid_view);

        final ArrayList<Sounds> soundsArrayList = new ArrayList<>();

        soundsArrayList.add(new Sounds(R.drawable.cow, "Cow", R.raw.cow));
        soundsArrayList.add(new Sounds(R.drawable.cat, "Cat", R.raw.cat));
        soundsArrayList.add(new Sounds(R.drawable.dog, "Dog", R.raw.dog));
        soundsArrayList.add(new Sounds(R.drawable.duck, "Duck", R.raw.duck));
        soundsArrayList.add(new Sounds(R.drawable.lion, "Lion", R.raw.lion));
        soundsArrayList.add(new Sounds(R.drawable.chimpanzee, "Chimpanzee", R.raw.chimpanzee));

        final SoundsAdapter soundsAdapter = new SoundsAdapter(this, soundsArrayList);

        GridView soundListGridView = findViewById(R.id.soundListGridView);
        soundListGridView.setAdapter(soundsAdapter);

        soundListGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                soundsPosition = soundsArrayList.get(position);

                // Release media player if it currently exists since we are about to play a different sound file
                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(AnimalSoundsActivity.this, soundsPosition.getAudioResourceId());
                mediaPlayer.start();

                // Setup a listener on media player so that we can stop and release media player once the sound has finished playing
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });

                soundsAdapter.notifyDataSetChanged();
            }
        });
    }

    protected void onStop(){
        super.onStop();
        // When activity is stopped release media player resources because we won't be playing any more sounds
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound
        if (mediaPlayer != null) {
            // Regardless of current state of media player, release its resources since we no longer need it
            mediaPlayer.release();
            // Set media player back to null, this confirms that the media player is not configured to play an audio file at the moment
            mediaPlayer = null;
        }
    }
}
