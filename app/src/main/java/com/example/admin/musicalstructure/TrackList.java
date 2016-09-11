package com.example.admin.musicalstructure;

/**
 * Created by admin on 9/6/2016.
 */
public class TrackList {

    // Name of the Song
    private String mSongName;

    // Artist Name
    private String mSongArtist;

    // Song Icon
    private int mImageResourceId;

    /*
    * Create a new TrackList object.
    *
    * @param vName is the name of the Song
    * @param vArtist is the corresponding Artist name
    * @param image is drawable reference ID that corresponds to the Song
    * */
    public TrackList(String vName, String vArtist, int imageResourceId) {
        mSongName = vName;
        mSongArtist = vArtist;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the Song
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the Song Artist
     */
    public String getSongArtist() {
        return mSongArtist;
    }

    /**
     * Get the image resource ID for Song art
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}