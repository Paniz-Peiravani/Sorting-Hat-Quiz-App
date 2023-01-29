package com.example.sortinghat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * First window when user open the app.
 * Ask the user name to show at the end.
 *
 * @author Paniz Peiravani
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    Button bte_start;
    TextView et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bte_start = findViewById(R.id.btn_start);
        et_name = findViewById(R.id.et_name);

        bte_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence name_et = (CharSequence) et_name.getText().toString();
                if (name_et.length() == 0) {
                    Toast.makeText((Context) MainActivity.this, (CharSequence) "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent((Context) MainActivity.this, QuizQuestionsActivity.class);
                    intent.putExtra("name", name_et);
                    MainActivity.this.startActivity(intent);
                    MainActivity.this.finish();

                }

            }
        });
    }
}