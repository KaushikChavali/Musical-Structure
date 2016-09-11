package com.example.admin.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by admin on 9/10/2016.
 */
public class PlaylistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = getIntent().getExtras();

        String playlistName = bundle.getString("PLAYLIST_NAME");


        getSupportActionBar().setTitle(playlistName);

        // Create an ArrayList of AndroidFlavor objects
        ArrayList<TrackList> trackLists = new ArrayList<TrackList>();
        trackLists.add(new TrackList("The Greatest", "Sia", R.drawable.placeholder));
        trackLists.add(new TrackList("Smooth Criminal", "Michael Jackson", R.drawable.placeholder));


        // Create an {@link TrackListAdapter}, whose data source is a list of
        // {@link TrackList}s. The adapter knows how to create list item views for each item
        // in the list.
        final TrackListAdapter trackListAdapter = new TrackListAdapter(this, trackLists);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_tracks);
        listView.setAdapter(trackListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                TrackList trackList = (TrackList) trackListAdapter.getItem(position);
                String songName = (String) trackList.getSongName();
                String songArtist = (String) trackList.getSongArtist();

                Toast.makeText(getBaseContext(), "Playing", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), PlayerActivity.class);

                Bundle bundle = new Bundle();

                bundle.putString("SONG_NAME", songName);
                bundle.putString("SONG_ARTIST", songArtist);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}