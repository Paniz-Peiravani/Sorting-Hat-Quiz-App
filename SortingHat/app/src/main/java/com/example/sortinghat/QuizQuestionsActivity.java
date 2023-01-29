package com.example.sortinghat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestionsActivity extends AppCompatActivity {

    //set controls
    TextView tvQuestions;

    Button bteOpt1, bteOpt2, bteOpt3, bteOpt4;

    int gryffindor = 0;
    int hufflepuff = 0;
    int ravenclaw = 0;
    int slytherin = 0;

    //list for questions
    List<Questions> questionList = new ArrayList<>();

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);

        //find view by ids

        tvQuestions = findViewById(R.id.tvQuestions);


        bteOpt1 = findViewById(R.id.bteOpt1);
        bteOpt2 = findViewById(R.id.bteOpt2);
        bteOpt3 = findViewById(R.id.bteOpt3);
        bteOpt4 = findViewById(R.id.bteOpt4);

        //Question #1
        questionList.add(new Questions("Q1) When I'm dead, I want people to remember me as:", "a) The Bold", "b) The Good", "c) The Wise", "d) The Great"));
        //Question #2
        questionList.add(new Questions("Q2) Given the choice, would you rather invent a potion that would guarantee you", "a) Glory", "b) Love", "c) Wisdom", "d) Power"));
        //Question #3
        questionList.add(new Questions("Q3) Which kind of instrument most pleases your ear?", "a) The drum", "b) The piano", "c) The violin", "d) The trumpet"));
        //Question #4
        questionList.add(new Questions("Q4) Which road tempts you the most?", "a) The twisting, leaf-strewn path through woods", "b) The wide, sunny grassy lane", "c) The cobbled street lined (ancient buildings)", "d) The narrow, dark, lantern-lit alley"));

        loadQuestion(counter);

        bteOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gryffindor++;
                counter++;
                if(counter < questionList.size())
                {
                    loadQuestion(counter);
                }
                else
                {
                    goToResults();
                }
            }
        });


        bteOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hufflepuff++;
                counter++;
                if(counter < questionList.size())
                {
                    loadQuestion(counter);
                }
                else
                {
                    goToResults();
                }
            }
        });

        bteOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ravenclaw++;
                counter++;
                if(counter < questionList.size())
                {
                    loadQuestion(counter);
                }
                else
                {
                    goToResults();
                }
            }
        });

        bteOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slytherin++;
                counter++;
                if(counter < questionList.size())
                {
                    loadQuestion(counter);
                }
                else
                {
                    goToResults();
                }

            }
        });


    }

    private void loadQuestion(int counter) {
        Questions questions = questionList.get(counter);
        tvQuestions.setText(questions.getQuestion());
        bteOpt1.setText(questions.getOpt1());
        bteOpt2.setText(questions.getOpt2());
        bteOpt3.setText(questions.getOpt3());
        bteOpt4.setText(questions.getOpt4());
    }

    private void goToResults()
    {
        //find the house with max point
        int max = 0;
        String house = "";

        if (gryffindor > max) {
            max = gryffindor;
            house = "Gryffindor";
        }

        if (hufflepuff > max) {
            max = hufflepuff;
            house = "Hufflepuff";
        }

        if (ravenclaw > max) {
            max = ravenclaw;
            house = "Ravenclaw";
        }

        if (slytherin > max) {
            max = slytherin;
            house = "Slytherin";
        }

        Intent intentGet = getIntent();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("houseName", house);
        intent.putExtra("name", intentGet.getStringExtra("name"));
        startActivity(intent);
        finish();
    }
}