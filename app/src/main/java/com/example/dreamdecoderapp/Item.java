package com.example.dreamdecoderapp;

public class Item {
    private int id;
    private String description;
    private String dateCreated;
    private String dreamEmotions;
    private String dreamSymbols;
    private int ownerId;

    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDreamEmotions() {
        return dreamEmotions;
    }

    public void setDreamEmotions(String dreamEmotions) {
        this.dreamEmotions = dreamEmotions;
    }

    public String getDreamSymbols() {
        return dreamSymbols;
    }

    public void setDreamSymbols(String dreamSymbols) {
        this.dreamSymbols = dreamSymbols;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
