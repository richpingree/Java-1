//created by Richard Pingree

package com.richardpingree.javaproject3;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

/**
 * Created by richardpingree on 12/16/14.
 */
public class Artist {

    public String artistName;
    public String artistGenre;
    public String artistLabel;
    public String artistCountry;
    public String artistCity;
    public String artistState;

    public Artist (){}

    public Artist(String name, String genre, String label, String country, String city, String state){
            artistName = name;
            artistGenre = genre;
            artistLabel = label;
            artistCountry = country;
            artistCity = city;
            artistState = state;

    }

    public Artist(JSONObject artistData){
            try{
                artistName = artistData.getString("name");
                artistGenre = artistData.getString("genre");
                artistLabel = artistData.getString("label");
                artistCountry = artistData.getString("country");
                artistCity = artistData.getString("city");
                artistState = artistData.getString("state");
            } catch (Exception e){

            //Log.e("Test", "Error occured.");
               }
    }

    //gets and sets data for object
    public String getArtistName(){
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistGenre(){
        return artistGenre;
    }

    public void setArtistGenre(String artistGenre) {
        this.artistGenre = artistGenre;
    }

    public String getArtistLabel(){
        return artistLabel;
    }

    public void setArtistLabel(String artistLabel) {
        this.artistLabel = artistLabel;
    }

    public String getArtistCountry(){
        return artistCountry;
    }

    public void setArtistCountry(String artistCountry){
        this.artistCountry = artistCountry;
    }

    public String getArtistCity(){
        return artistCity;
    }

    public void setArtistCity(String artistCity){
        this.artistCity = artistCity;
    }
    String getArtistState(){
        return artistState;
    }

    public void setArtistState(String artistState){
        this.artistState = artistState;
    }

}


