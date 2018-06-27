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

import helpers.Precision;

public class SimultEqnsActivity extends AppCompatActivity {

    TextView equationText;

    EditText xText;
    EditText yText;

    Button nextBtn;

    Integer a;
    Integer b;
    Integer c;
    Integer d;
    Integer e;
    Integer f;

    double DX;
    double DY;

    double x;
    double y;

    double xDouble;
    double yDouble;


    String ansX;
    String ansY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simult_eqns);

        equationText = (TextView) findViewById(R.id.question_text);

        xText = (EditText) findViewById(R.id.ansTextx);

        yText = (EditText) findViewById(R.id.ansTexty);

        nextBtn = (Button) findViewById(R.id.nextBtn);

        genEquation();;

       nextBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(xText.getText().toString().equals("")|| yText.getText().toString().equals("")){
                   Toast.makeText(SimultEqnsActivity.this, "Please enter both answers, to get a solution!",
                           Toast.LENGTH_LONG).show();
               }else {
                   checkAns();
               }
           }
       });


    }


    public void genEquation(){

        xText.setText("");
        yText.setText("");

        Random r1 = new Random();
        a = r1.nextInt(10-(-10))+(-10);

        Random r2 = new Random();
        b = r2.nextInt(10-(-10))+(-10);

        Random r3 = new Random();
        c = r3.nextInt(10-(-10))+(-10);

        Random r4 = new Random();
        d = r4.nextInt(10-(-10))+(-10);

        Random r5 = new Random();
        e = r5.nextInt(10-(-10))+(-10);

        Random r6 = new Random();
        f = r6.nextInt(10-(-10))+(-10);



        equationText.setText(a+"x + "+b+"y = "+c+"\n"+d+"x + "+e+"y = "+f);

        solveEquation();

    }

    public void solveEquation(){

        double D = ((a*e)-(b*d));

        if(D !=0){

            DX = ((c*e)-(b*f));

            DY = ((a*f)-(c*d));


            x = DX/D;

            y = DY/D;



            if(Double.isInfinite(x)){
                genEquation();
            }else{
                if (x % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("##");
                    ansX = format.format(x);
                } else {

                    xDouble = Precision.round(x,2);
                    ansX = Double.toString(xDouble);

                }
            }

            if(Double.isInfinite(y)){
                genEquation();
            }else{
                if (y % 1 == 0) {
                    DecimalFormat format = new DecimalFormat("##");
                    ansY = format.format(y);
                } else {

                    yDouble = Precision.round(y,2);
                    ansY = Double.toString(yDouble);

                }
            }

        }else{

            ansX = "No Solution";

            ansY = "No Solution";

        }


    }

    public void checkAns(){

        if (xText.getText().toString().equals(ansX)&&yText.getText().toString().equals(ansY)){
            nextCorrectAns(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(SimultEqnsActivity.this, "The correct answer is :\nx = "+ansX+" \ny = "+ansY,
                            Toast.LENGTH_LONG).show();
                    genEquation();
                }
            });



        }else if (xText.getText().toString().equals(ansX)||yText.getText().toString().equals(ansY)){
            halfCorrect(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(SimultEqnsActivity.this, "The correct answer is :\nx = "+ansX+" \ny = "+ansY,
                            Toast.LENGTH_LONG).show();
                    genEquation();
                }
            });


        }

        else{
            notCorrect(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(SimultEqnsActivity.this, "The correct answer is :\nx = "+ansX+" \ny = "+ansY,
                            Toast.LENGTH_LONG).show();
                    genEquation();
                }
            });


        }


    }


    private void nextCorrectAns(DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(SimultEqnsActivity.this)
                .setTitle("Good Job! ")
                .setMessage("You got it right!")
                .setPositiveButton("Move On!", okListener)
                .create()
                .show();
    }

    private void halfCorrect(DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(SimultEqnsActivity.this)
                .setTitle("So Close!")
                .setMessage("One of your answers are right!")
                .setPositiveButton("Move On", okListener)
                .setNegativeButton("Try again", null)
                .create()
                .show();
    }

    private void notCorrect(DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(SimultEqnsActivity.this)
                .setTitle("Wrong! Try harder.")
                .setMessage("Remember to write your answer rounded to two decimal places.")
                .setPositiveButton("Move On", okListener)
                .setNegativeButton("Try again", null)
                .create()
                .show();
    }

}
