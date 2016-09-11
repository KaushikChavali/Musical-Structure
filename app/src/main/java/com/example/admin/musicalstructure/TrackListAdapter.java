package com.example.admin.musicalstructure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 9/6/2016.
 */
public class TrackListAdapter extends ArrayAdapter<TrackList> {

    private static final String LOG_TAG = TrackListAdapter.class.getSimpleName();

    public TrackListAdapter(Activity context, ArrayList<TrackList> trackLists) {
        super(context, 0, trackLists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link TrackList} object located at this position in the list
        TrackList currentTrackList = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.song_name);
        nameTextView.setText(currentTrackList.getSongName());

        TextView artistTextView = (TextView) listItemView.findViewById(R.id.song_artist);
        artistTextView.setText(currentTrackList.getSongArtist());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.song_icon);
        iconView.setImageResource(currentTrackList.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}