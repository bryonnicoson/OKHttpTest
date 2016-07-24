package com.bryonnicoson.okhttptest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bryon on 7/23/16.
 */
public class Book {
    private String title;
    private String author;
    private int yearPublished;
    @SerializedName("Setting")
    private String setting;
    private Boolean isFiction;
    @SerializedName("Characters")
    private List<String> characters;

    Book() {
        // no args constructor
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public Boolean getFiction() {
        return isFiction;
    }

    public void setFiction(Boolean fiction) {
        isFiction = fiction;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getCharacterString() {
        StringBuilder characterString = new StringBuilder();
        for (String character : characters)
            characterString.append(character + "\n");
        return characterString.toString();
    }
}
