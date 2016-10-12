package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.asynctask.FetchJokeTask;
import com.udacity.gradle.jokedisplay.JokeActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ProgressBar spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        spinner = (ProgressBar) root.findViewById(R.id.progress_bar);
        spinner.setVisibility(View.GONE);

        Button getJokeButton = (Button) root.findViewById(R.id.joke_button);
        getJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        return root;
    }

    private void tellJoke() {
        spinner.setVisibility(View.VISIBLE);

        new FetchJokeTask() {
            @Override
            protected void onPostExecute(String joke) {
                Intent intent = new Intent(getContext(), JokeActivity.class);
                intent.putExtra(JokeActivity.JOKE_KEY, joke);
                startActivity(intent);

                spinner.setVisibility(View.GONE);
            }
        }.execute();
    }
}
