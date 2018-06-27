package com.example.anuda.mathapp.quadratics;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anuda.mathapp.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.Random;

import helpers.Precision;

import static com.example.anuda.mathapp.R.string.d;

public class QuadraticEquationsActivity extends AppCompatActivity {

    TextView equation;
    Button next;
    EditText x1Text;
    EditText x2Text;

    int a;
    int b;
    int c;
    double x1;
    double x2;
    double d;
    String ans1;
    String ans2;

    double x1Double;
    double x2Double;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic_equations);

        equation = (TextView) findViewById(R.id.question_text);
        x1Text = (EditText) findViewById(R.id.ansTextX1);
        x2Text = (EditText) findViewById(R.id.ansTextX2);

        genEquation();

        next = (Button) findViewById(R.id.nextBtn);


        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public String toString() {
                return "$classname{}";
            }

            @Override
            public void onClick(View v) {

                if(x1Text.getText().toString().equals("")|| x2Text.getText().toString().equals("")){
                    Toast.makeText(QuadraticEquationsActivity.this, "Please enter both answers, to get a solution!",
                            Toast.LENGTH_LONG).show();
                }else {
                    checkAns();
                }


            }
        });

    }


    public void genEquation(){

        x1Text.setText("");
        x2Text.setText("");

        Random r1 = new Random();
        a = r1.nextInt(10-(-10))+(-10);

        Random r2 = new Random();
        b = r2.nextInt(20-(-20))+(-20);

        Random r3 = new Random();
        c = r3.nextInt(10-(-10))+(-10);

        d= Math.pow(b,2) - 4 * a * c;


        if(d==0|d<0){
            genEquation();


        }else if (a==0){
            genEquation();
        }
        else{

            equation.setText(a+"x² +"+" "+b+"x = "+c*-1);

            solveEquation();

        }

    }

    public void solveEquation(){

            x1 = (-b + Math.sqrt(d))/(2*a);
            x2 = (-b - Math.sqrt(d))/(2*a);

//        DecimalFormat format = new DecimalFormat("##.00");

//        ans1 = format.format(x1);
//
//        ans2 = format.format(x2);

        if(x1==-0){
            x1=0;
        }

        if(x2==-0){
            x2=0;
        }

        if(Double.isInfinite(x1)){
            genEquation();
        }else{
            if (x1 % 1 == 0) {
                DecimalFormat format = new DecimalFormat("##");
                ans1 = format.format(x1);
            } else {

                x1Double = Precision.round(x1,2);
                ans1 = Double.toString(x1Double);

            }
        }

        if(Double.isInfinite(x2)){
            genEquation();
        }else{
            if (x2 % 1 == 0) {
                DecimalFormat format = new DecimalFormat("##");
                ans2 = format.format(x2);
            } else {

                x2Double = Precision.round(x2,2);
                ans2 = Double.toString(x2Double);

            }
        }


    }

    public void checkAns(){
        if(x1Text.getText().toString().equals(ans1)&&x2Text.getText().toString().equals(ans2)){

            nextCorrectAns(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(QuadraticEquationsActivity.this, "The correct answer is :\nx1 = "+ans1+" \nx2 = "+ans2,
                            Toast.LENGTH_LONG).show();
                    genEquation();
                }
            });

        }else if (x2Text.getText().toString().equals(ans1)&&x1Text.getText().toString().equals(ans2)){
            nextCorrectAns(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(QuadraticEquationsActivity.this, "The correct answer is :\nx1 = "+ans1+" \nx2 = "+ans2,
                            Toast.LENGTH_LONG).show();
                    genEquation();
                }
            });
        }else if (x1Text.getText().toString().equals(ans1)||x2Text.getText().toString().equals(ans2)){

            halfCorrect(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(QuadraticEquationsActivity.this, "The correct answer is :\nx1 = "+ans1+" \nx2 = "+ans2,
                            Toast.LENGTH_LONG).show();
                    genEquation();
                }
            });


        }else if(x1Text.getText().toString().equals(ans2)||x2Text.getText().toString().equals(ans1)){
            halfCorrect(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(QuadraticEquationsActivity.this, "The correct answer is :\nx1 = "+ans1+" \nx2 = "+ans2,
                            Toast.LENGTH_LONG).show();
                    genEquation();
                }
            });
        }

        else{
            notCorrect(new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(QuadraticEquationsActivity.this, "x1 = "+ans1+" \nx2 = "+ans2,
                            Toast.LENGTH_LONG).show();
                    genEquation();
                }
            });
        }

    }

    private void nextCorrectAns(DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(QuadraticEquationsActivity.this)
                .setTitle("Good Job! ")
                .setMessage("You got it right!")
                .setPositiveButton("Move On!", okListener)
                .create()
                .show();
    }

    private void halfCorrect(DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(QuadraticEquationsActivity.this)
                .setTitle("So Close!")
                .setMessage("One of your answers are right!")
                .setPositiveButton("Move On", okListener)
                .setNegativeButton("Try again", null)
                .create()
                .show();
    }

    private void notCorrect(DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(QuadraticEquationsActivity.this)
                .setTitle("Wrong! Try harder.")
                .setMessage("Remember to write your answer rounded to two decimal places.")
                .setPositiveButton("Move On", okListener)
                .setNegativeButton("Try again", null)
                .create()
                .show();
    }


}
