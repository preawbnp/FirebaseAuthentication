package com.example.preawbnp.firebaselogin;

/**
 * Created by preawbnp on 12/3/2018 AD.
 */

public class ViewSingleItem {
    //Constructor must same name with database
    private String Image_URL, Image_Title;

    public ViewSingleItem (String image_URL, String image_Title) {
        Image_URL = image_URL;
        Image_Title = image_Title;
    }

    public ViewSingleItem() {
        //constructor
    }

    public String getImage_URL() {
        return Image_URL;
    }

    public String getImage_Title() {
        return Image_Title;
    }

    public void setImage_URL (String image_URL) {
        Image_URL = image_URL;
    }

    public void setImage_Title (String image_Title) {
        Image_Title = image_Title;
    }
}


