package com.udacity.gradle.builditbigger.backend;

import com.example.android.jokesource.JokeSource;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com"
        )
)
public class MyEndpoint {


    @ApiMethod(name = "getJoke")
    public Joke getJoke(){
        Joke joke = new Joke();
        String jokeContent = new JokeSource().getJoke();
        joke.setData(jokeContent);
        return joke;
    }
}
