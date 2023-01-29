package com.example.sortinghat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Last window of the app.
 * Sorting the Hogwarts house and show the result.
 *
 * @author Paniz Peiravani
 * @version 1.0
 */
public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView username, final_house, tv_Congratulation;



        username = findViewById(R.id.username);
        final_house = findViewById((R.id.final_house));
        tv_Congratulation = findViewById((R.id.tv_Congratulation));


        Intent intent = getIntent();
        String house = intent.getStringExtra("houseName");
        final_house.setText(house);
        String name = intent.getStringExtra("name");
        username.setText(name);
    }
}