package com.example.fefu_test;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main_Listitem extends AppCompatActivity {

    private int userImage;
    private int location_icon;
    private int userPicture;

    private String userId;
    private String date;
    private String userLocation;
    private String userText;

    private Button share_btn;

    public Main_Listitem(int userImage, int location_icon, int userPicture, String userid, String date, String userlocation, String userText) {
        this.userImage = userImage;
        this.location_icon = location_icon;
        this.userPicture = userPicture;
        this.userId = userid;
        this.date = date;
        this.userLocation = userlocation;
        this.userText = userText;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public int getLocation_icon() {
        return location_icon;
    }

    public void setLocation_icon(int location_icon) {
        this.location_icon = location_icon;
    }

    public int getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(int userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserid() {
        return userId;
    }

    public void setUserid(String userid) { this.userId = userid; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserLocation() { return userLocation; }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserText() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText = userText;
    }
}
