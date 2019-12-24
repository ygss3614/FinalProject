package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class Joke {

    private String jokeString;

    public String getData() {
        return jokeString;
    }

    public void setData(String joke) {
        jokeString = joke;
    }
}