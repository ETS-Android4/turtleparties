package com.example.turtlepartiesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Player search acitivyti
 * To DO: Improve effectiveness and info displayed
 */
public class PlayerSearchActivity extends AppCompatActivity {

    ListView playerList;
    ArrayAdapter<Player> playerAdapter;
    ArrayList<Player> players;

    PlayerSearcherController searcherController;

    ResultHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_search);
        
        handler = new ResultHandler() {
            @Override
            public void handleResult(Object data) {
                playerAdapter.notifyDataSetChanged();
            }
        };

        playerList = findViewById(R.id.playerListView);
        players = new ArrayList<Player>();
        playerAdapter= new PlayerListAdapter(this, players);
        playerList.setAdapter(playerAdapter);

        searcherController = new PlayerSearcherController();
    }


    public void onClickSearch(View view){
        EditText editText = (EditText) findViewById(R.id.search_text);
        String name = editText.getText().toString();

        searcherController.searchByName(name, players,20, handler);
    }
}