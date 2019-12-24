package com.example.android.jokedisplay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link JokeDisplayFragment} factory method to
 * create an instance of this fragment.
 */
public class JokeDisplayFragment extends Fragment {


    public JokeDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_joke_display, container, false);

        // Get joke by intent
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokeActivity.EXTRA_JOKE);
        TextView jokeTextView = (TextView) root.findViewById(R.id.joke_display_tv);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }

        return root;

    }







}
