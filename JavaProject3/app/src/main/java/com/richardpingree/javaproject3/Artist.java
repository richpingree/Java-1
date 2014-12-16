package com.richardpingree.javaproject3;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by richardpingree on 12/16/14.
 */
public class Artist {

    String artistName;
    String artistGenre;
    String artistLabel;

    Artist(){}

    Artist(String name, String genre, String label){
        artistName = name;
        artistGenre = genre;
        artistLabel = label;
    }

    Artist(JSONObject artistData){
        try{
            artistName = artistData.getString("name");
            artistGenre = artistData.getString("genre");
            artistLabel = artistData.getString("label");
        } catch (Exception e){
            Log.e("Test", "Error occured.");
        }
    }

    String getArtistName(){
        return artistName;
    }

    void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    String getArtistGenre(){
        return artistGenre;
    }

    void setArtistGenre(String artistGenre) {
        this.artistGenre = artistGenre;
    }

    String getArtistLabel(){
        return artistLabel;
    }

    void setArtistLabel(String artistLabel) {
        this.artistLabel = artistLabel;
    }

}


