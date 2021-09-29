package com.example.android.mowik;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class number extends AppCompatActivity {
    ArrayList<word> words = new ArrayList<word>();


    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        words.add(new word("one", "एक", R.drawable.number_one, R.raw.number_one));
        words.add(new word("two", "दो", R.drawable.number_two, R.raw.number_two));
        words.add(new word("three", "तीन", R.drawable.number_three, R.raw.number_three));
        words.add(new word("four", "चार", R.drawable.number_four, R.raw.number_four));
        words.add(new word("five", "पांच", R.drawable.number_five, R.raw.number_five));
        words.add(new word("six", "छ:", R.drawable.number_six, R.raw.number_six));
        words.add(new word("seven", "सात", R.drawable.number_seven, R.raw.number_seven));
        words.add(new word("eight", "आठ", R.drawable.number_eight, R.raw.number_eight));
        words.add(new word("nine", "नौ", R.drawable.number_nine, R.raw.number_nine));
        words.add(new word("ten", "दस", R.drawable.number_ten, R.raw.number_ten));
        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = words.get(position);
                Toast.makeText(number.this, "clicked", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                player = MediaPlayer.create(number.this, word.getMsongid());
                player.start();

                player = MediaPlayer.create(number.this, word.getMsongid());
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });


            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
        Toast.makeText(this, "stop_called", Toast.LENGTH_SHORT).show();
    }


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (player != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            player.release();
            Toast.makeText(this, "released", Toast.LENGTH_SHORT).show();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            player = null;

        }
    }
}


