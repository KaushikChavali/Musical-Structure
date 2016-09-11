package com.example.admin.musicalstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 9/9/2016.
 */
public class PlayerActivity extends AppCompatActivity {

    int counter = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();

        String songName = bundle.getString("SONG_NAME");
        String songArtist = bundle.getString("SONG_ARTIST");

        TextView textView1 = (TextView) findViewById(R.id.song_name);
        textView1.setText(songName);

        TextView textView2 = (TextView) findViewById(R.id.song_artist);
        textView2.setText(songArtist);

        final ImageButton button = (ImageButton) findViewById(R.id.play_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (counter % 2 == 0) {
                    button.setImageResource(android.R.drawable.ic_media_pause);
                    Toast.makeText(getBaseContext(), "Playing", Toast.LENGTH_SHORT).show();
                } else {
                    button.setImageResource(android.R.drawable.ic_media_play);
                    Toast.makeText(getBaseContext(), "Pausing", Toast.LENGTH_SHORT).show();
                }
                counter++;
            }
        });
    }
}
