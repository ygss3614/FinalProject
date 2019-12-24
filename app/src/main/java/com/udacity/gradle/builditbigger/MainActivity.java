package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.jokedisplay.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String joke) {
                startJokeActivity(joke);
            }

        }.execute();
    }

    public void startJokeActivity(String joke){
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_JOKE, joke);
        startActivity(intent);
    }
}
