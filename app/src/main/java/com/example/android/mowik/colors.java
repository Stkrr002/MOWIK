package com.example.android.mowik;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class colors extends AppCompatActivity {
    ArrayList<word> words=new ArrayList<word>();
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        words.add(new word("red","लाल",R.drawable.color_red,R.raw.color_red));
        words.add(new word("green","हरा",R.drawable.color_green,R.raw.color_green));
        words.add(new word("brown","भूरा",R.drawable.color_brown,R.raw.color_brown));
        words.add(new word("gray","स्लेटी",R.drawable.color_gray,R.raw.color_gray));
        words.add(new word("black","काला",R.drawable.color_black,R.raw.color_black));
        words.add(new word("white","सफ़ेद",R.drawable.color_white,R.raw.color_white));
        words.add(new word("dusty yellow","पीला",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new word("mustard yellow","सरसोयी पीला",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this,  words);

        ListView listView = (ListView) findViewById(R.id.listcolor);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word woord = words.get(position);
                Toast.makeText(colors.this, "clicked", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                player = MediaPlayer.create(colors.this, woord.getMsongid());

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