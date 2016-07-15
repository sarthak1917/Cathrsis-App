package com.example.sarthak.cathapp.model;

/**
 * Created by Sarthak on 4/5/2016.
 */
public class EventData {
    private int image;
    private String name,descp;

    public EventData(int image, String name, String descp) {
        this.image = image;
        this.name = name;
        this.descp = descp;
    }

    public EventData() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }
}
