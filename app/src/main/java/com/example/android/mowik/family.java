package com.example.android.mowik;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.mowik.R.*;


public class family extends AppCompatActivity {
    ArrayList<word> words=new ArrayList<word >();
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_family);
        words.add(new word("father","पिता", drawable.family_father, raw.family_father));
        words.add(new word("mother","माता", drawable.family_mother,raw.family_mother));
        words.add(new word("daughter","बेटी", drawable.family_daughter,raw.family_daughter));
        words.add(new word("son","बेटा", drawable.family_son,raw.family_son));

        words.add(new word("grandfather","दादा जी", drawable.family_grandfather,raw.family_grandfather));
        words.add(new word("grandmother","दादी जी", drawable.family_grandmother,raw.family_grandmother));
        words.add(new word("older brother","बड़ा भाई", drawable.family_older_brother,raw.family_older_brother));
        words.add(new word("older sister","बड़ी बहन", drawable.family_older_sister,raw.family_older_sister));
        words.add(new word("younger brother","छोटा भाई", drawable.family_younger_brother,raw.family_younger_brother));
        words.add(new word("younger sister","छोटी बहन", drawable.family_younger_sister,raw.family_younger_sister));
        WordAdapter adapter = new WordAdapter(this,  words);

        ListView listView = (ListView) findViewById(id.listfamily);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = words.get(position);
                Toast.makeText(family.this, "clicked", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                player = MediaPlayer.create(family.this, word.getMsongid());

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