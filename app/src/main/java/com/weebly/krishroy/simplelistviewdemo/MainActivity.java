package com.weebly.krishroy.simplelistviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    ArrayList<String> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] tempList = {"Bacon", "Ham", "Tuna", "Candy", "Meatball", "Potato"};
        foods = new ArrayList<>(Arrays.asList(tempList));


        final ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);


        ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, food, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }



}
