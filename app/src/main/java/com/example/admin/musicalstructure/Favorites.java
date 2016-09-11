package com.example.admin.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by admin on 9/10/2016.
 */
public class Favorites extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tracks, container, false);


        // Create an ArrayList of TrackList objects
        ArrayList<TrackList> trackLists = new ArrayList<TrackList>();
        trackLists.add(new TrackList("See You Again", "Wiz Khalifa", R.drawable.placeholder));
        trackLists.add(new TrackList("Cheap Thrills", "Sia", R.drawable.placeholder));


        // Create an {@link TrackListAdapter}, whose data source is a list of
        // {@link TrackList}s. The adapter knows how to create list item views for each item
        // in the list.
        final TrackListAdapter trackAdapter = new TrackListAdapter(getActivity(), trackLists);

        // Get a reference to the ListView, and attach the adapter to the listView.
        final ListView listView = (ListView) rootView.findViewById(R.id.listview_tracks);
        listView.setAdapter(trackAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                TrackList trackList = (TrackList) trackAdapter.getItem(position);
                String songName = (String) trackList.getSongName();
                String songArtist = (String) trackList.getSongArtist();

                Toast.makeText(getContext(), "Playing", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), PlayerActivity.class);

                Bundle bundle = new Bundle();

                bundle.putString("SONG_NAME", songName);
                bundle.putString("SONG_ARTIST", songArtist);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        return rootView;
    }
}