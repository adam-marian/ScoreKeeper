package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {

    // Tracks the score and fouls for Gryffindor
    int scoreGryffindor = 0;
    int foulsByGryffindor = 0;
    // Tracks the score and fouls for Slytherin
    int scoreSlytherin = 0;
    int foulsBySlytherin = 0;

    // Save values on screen rotation
    static final String STATE_SCOREGRYFFINDOR = "scoreGryffindor";
    static final String STATE_SCORESLYTHERIN = "scoreSlytherin";
    static final String STATE_FOULSGRYFFINDOR = "foulsByGryffindor";
    static final String STATE_FOULSSLYTHERIN = "foulsBySlytherin";

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the current score and fouls state
        savedInstanceState.putInt(STATE_SCOREGRYFFINDOR, scoreGryffindor);
        savedInstanceState.putInt(STATE_SCORESLYTHERIN, scoreSlytherin);
        savedInstanceState.putInt(STATE_FOULSGRYFFINDOR, foulsByGryffindor);
        savedInstanceState.putInt(STATE_FOULSSLYTHERIN, foulsBySlytherin);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        scoreGryffindor = savedInstanceState.getInt(STATE_SCOREGRYFFINDOR);
        scoreSlytherin = savedInstanceState.getInt(STATE_SCORESLYTHERIN);
        foulsByGryffindor = savedInstanceState.getInt(STATE_FOULSGRYFFINDOR);
        foulsBySlytherin = savedInstanceState.getInt(STATE_FOULSSLYTHERIN);

        displayForGryffindor(scoreGryffindor);
        displayForSlytherin(scoreSlytherin);
        displayFoulsGryffindor(foulsByGryffindor);
        displayFoulsSlytherin(foulsBySlytherin);
    }

    /**
     * Penalty for Gryffindor.
     */
    public void penaltyForGryffindor(View v) {
        scoreGryffindor = scoreGryffindor + 10;
        foulsBySlytherin = foulsBySlytherin + 1;
        displayForGryffindor(scoreGryffindor);
        displayFoulsSlytherin(foulsBySlytherin);
    }

    /**
     * Increase the score for Gryffindor by 10 points.
     */
    public void addTenForGryffindor(View v) {
        scoreGryffindor = scoreGryffindor + 10;
        displayForGryffindor(scoreGryffindor);
    }

    /**
     * Increase the score for Gryffindor by 150 points.
     */
    public void addSnitchForGryffindor(View v) {
        scoreGryffindor = scoreGryffindor + 150;
        displayForGryffindor(scoreGryffindor);
    }

    /**
     * Penalty for Slytherin.
     */
    public void penaltyForSlytherin(View v) {
        scoreSlytherin = scoreSlytherin + 10;
        foulsByGryffindor = foulsByGryffindor + 1;
        displayForSlytherin(scoreSlytherin);
        displayFoulsGryffindor(foulsByGryffindor);
    }

    /**
     * Increase the score for Slytherin by 10 points.
     */
    public void addTenForSlytherin(View v) {
        scoreSlytherin = scoreSlytherin + 10;
        displayForSlytherin(scoreSlytherin);
    }

    /**
     * Increase the score for Slytherin by 150 points.
     */
    public void addSnitchForSlytherin(View v) {
        scoreSlytherin = scoreSlytherin + 150;
        displayForSlytherin(scoreSlytherin);
    }

    /**
     * Resets the score and fouls back to 0.
     */
    public void resetScore(View v) {
        scoreGryffindor = 0;
        scoreSlytherin = 0;
        foulsByGryffindor = 0;
        foulsBySlytherin = 0;
        displayForGryffindor(scoreGryffindor);
        displayForSlytherin(scoreSlytherin);
        displayFoulsGryffindor(foulsByGryffindor);
        displayFoulsSlytherin(foulsBySlytherin);

    }

    /**
     * Displays the given score for Gryffindor.
     */
    public void displayForGryffindor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.gryffindor_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays fouls for Gryffindor.
     */
    public void displayFoulsGryffindor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.fouls_gryffindor);
        scoreView.setText("Fouls: " + String.valueOf(score));
    }

    /**
     * Displays the given score for Slytherin.
     */
    public void displayForSlytherin(int score) {
        TextView scoreView = (TextView) findViewById(R.id.slytherin_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays fouls for Slytherin.
     */
    public void displayFoulsSlytherin(int score) {
        TextView scoreView = (TextView) findViewById(R.id.fouls_slytherin);
        scoreView.setText("Fouls: " + String.valueOf(score));
    }
}