package com.example.android.mowik;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class phrases extends AppCompatActivity {
    ArrayList<word> words=new ArrayList<word >();
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        words.add(new word("Where are you going?","कहाँ जा रहे हो?",R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name?","तुम्हारा नाम क्या है?",R.raw.phrase_what_is_your_name));
        words.add(new word("My name is...","मेरा नाम....",R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling?","कैसा महसूस कर रहे हो?",R.raw.phrase_how_are_you_feeling));
        words.add(new word("I’m feeling good.","मैं अच्छा महसूस कर रहा/रही हूँ",R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?","क्या तुम आ रहे हो ?",R.raw.phrase_are_you_coming));
        words.add(new word("Yes, I’m coming.","हाँ, मै आ रहा हूँ ",R.raw.phrase_yes_im_coming));
        words.add(new word("I’m coming.","मै आ रहा हूँ",R.raw.phrase_im_coming));
        words.add(new word("Let’s go.","चलो चलें",R.raw.phrase_lets_go));
        words.add(new word("Come here.","इधर आओ",R.raw.phrase_come_here));
        words.add(new word("Do you know Sumit?","क्या तुम सुमित को जानते हो?",R.raw.phrase_how_are_you_feeling));
        words.add(new word("Yes, he is dumbest guy in the batch.","हाँ, वो बैच में सबसे मूर्ख लड़का है .",R.raw.phrase_lets_go));
        words.add(new word("what about his friends","उसके दोस्तों का क्या?",R.raw.phrase_im_feeling_good));
        words.add(new word("They are really brilliant","वो लोग सच मे समझदार हैं ",R.raw.phrase_how_are_you_feeling));

        WordAdapter adapter = new WordAdapter(this,  words);

        ListView listView = (ListView) findViewById(R.id.listphrase);

        listView.setAdapter(adapter);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word word = words.get(position);
                Toast.makeText(phrases.this, "clicked", Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
                 player = MediaPlayer.create(phrases.this, word.getMsongid());

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