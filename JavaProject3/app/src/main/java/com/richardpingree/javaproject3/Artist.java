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

    String artistName;
    String artistGenre;
    String artistLabel;
    String artistCountry;
    String artistCity;
    String artistState;

    Artist(){}

    Artist(String name, String genre, String label, String country, String city, String state){
        artistName = name;
        artistGenre = genre;
        artistLabel = label;
        artistCountry = country;
        artistCity = city;
        artistState = state;

    }

    Artist(JSONObject artistData){
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

    String getArtistCountry(){
        return artistCountry;
    }

    void setArtistCountry(String artistCountry){
        this.artistCountry = artistCountry;
    }

    String getArtistCity(){
        return artistCity;
    }

    void setArtistCity(String artistCity){
        this.artistCity = artistCity;
    }
    String getArtistState(){
        return artistState;
    }

    void setArtistState(String artistState){
        this.artistState = artistState;
    }

}


