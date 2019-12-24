package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;


import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;


import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;

    @Override
    protected String doInBackground(Void... voids) {
        //Check if mMyApiService instance is null
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://10.0.2.2:8080/_ah/api/") //10.0.2.2 is localhost's IP address in Android emulator
                    .setApplicationName("TellingJokes")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        //Get the joke from the API
        String joke;

        try {
            joke = myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            joke = "error on load";
        }

        return joke;
    }
}