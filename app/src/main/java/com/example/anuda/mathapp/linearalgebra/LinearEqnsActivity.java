package com.example.anuda.mathapp.linearalgebra;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anuda.mathapp.R;
import com.example.anuda.mathapp.quadratics.QuadraticEquationsActivity;

import java.text.DecimalFormat;
import java.util.Random;

public class LinearEqnsActivity extends AppCompatActivity {

    Button next;
    TextView eqnText;

    EditText ansText;


    int a;
    int b;
    int c;
    int d;

    double x;
    double dminb;
    double aminc;

    String xString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_eqns);

        eqnText = (TextView) findViewById(R.id.question_text);

        ansText = (EditText) findViewById(R.id.ansTextX);

        next = (Button) findViewById(R.id.nextBtn);

        genEquation();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ansText.getText().equals("")){
                    Toast.makeText(LinearEqnsActivity.this, "Please enter both answers, to get a solution!",
                            Toast.LENGTH_LONG).show();

                }else{
                    checkAns();
                }

            }
        });

    }


    public void genEquation(){


        ansText.setText("");

        Random r1 = new Random();
        a = r1.nextInt(10-0);

        Random r2 = new Random();
        b = r2.nextInt(10-0);

        Random r3 = new Random();
        c = r3.nextInt(10-0);

        Random r4 = new Random();
        d = r4.nextInt(10-0);

        if(a==0){
            eqnText.setText(b+" = "+c+"x + "+d);
        }else if(c==0){

            eqnText.setText(a+"x + "+b+" = "+d);

        }else if(b==0){

            eqnText.setText(a + "x" + " = " + c + "x + " + d);

        }else if(d==0){

            eqnText.setText(a + "x + " + b + " = " + c + "x");

        }else {
            eqnText.setText(a + "x + " + b + " = " + c + "x + " + d);
        }


        solveEquation();



    }

    public void solveEquation(){

        dminb = d-b;

        aminc = a-c;

        x = dminb/aminc;

        DecimalFormat format = new DecimalFormat("##.##");

        xString = format.format(x);

//        ansText.setText(xString);


    }


    public void checkAns(){

        if(ansText.getText().toString().equals(xString)){

            nextCorrectAns(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(LinearEqnsActivity.this, "The correct answer is :\nx = "+xString,
                            Toast.LENGTH_LONG).show();


                    genEquation();
                }
            });


        }else{
            notCorrect(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(LinearEqnsActivity.this, "The correct answer is :\nx = "+xString,
                            Toast.LENGTH_LONG).show();

                    genEquation();
                }
            });

        }

    }

    private void nextCorrectAns(DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(LinearEqnsActivity.this)
                .setTitle("Good Job! ")
                .setMessage("You got it right!")
                .setPositiveButton("Move On!", okListener)
                .create()
                .show();
    }


    private void notCorrect(DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(LinearEqnsActivity.this)
                .setTitle("Wrong! Try harder.")
                .setMessage("Remember to write your answer rounded to two decimal places.")
                .setPositiveButton("Move On", okListener)
                .setNegativeButton("Try again", null)
                .create()
                .show();
    }


}
