package com.example.anuda.mathapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    TextView mathFactsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mathFactsText = (TextView)findViewById(R.id.mathFacts_text);
        Button basicAlgebrabtn = (Button)findViewById(R.id.basicAlgebra_button);
        Button linearAlgebrabtn = (Button)findViewById(R.id.LinearAlgebra_button);
        Button quadraticsbtn = (Button) findViewById(R.id.quadratics_button);
        Button wordProblembtn = (Button) findViewById(R.id.word_button);

        basicAlgebrabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNew = new Intent(HomeActivity.this, BasicAlgActivity.class);
                startActivity(intentNew);
            }
        });

        linearAlgebrabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNew = new Intent (HomeActivity.this, LinearAlgActivity.class);
                startActivity(intentNew);
            }
        });

        quadraticsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNew = new Intent (HomeActivity.this, QuadraticsActivity.class);
                startActivity(intentNew);
            }
        });

        wordProblembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNew = new Intent (HomeActivity.this, WordActivity.class);
                startActivity(intentNew);
            }
        });


        mathFactGeneration();


    }



    public void mathFactGeneration(){

        Random r = new Random();
        int i1 = r.nextInt(26-1)+1;
        mathFactsText.setText(Integer.toString(i1));

        switch (i1){
            case 1:mathFactsText.setText(R.string.a);
                break;case 2:mathFactsText.setText(R.string.b);
                break;case 3:mathFactsText.setText(R.string.c);
                break;case 4:mathFactsText.setText(R.string.d);
                break;case 5:mathFactsText.setText(R.string.e);
                break;case 6:mathFactsText.setText(R.string.f);
                break;case 7:mathFactsText.setText(R.string.g);
                break;case 8:mathFactsText.setText(R.string.h);
                break;case 9:mathFactsText.setText(R.string.i);
                break;case 10:mathFactsText.setText(R.string.j);
                break;case 11:mathFactsText.setText(R.string.k);
                break;case 12:mathFactsText.setText(R.string.l);
                break;case 13:mathFactsText.setText(R.string.m);
                break;case 14:mathFactsText.setText(R.string.n);
                break;case 15:mathFactsText.setText(R.string.o);
                break;case 16:mathFactsText.setText(R.string.p);
                break;case 17:mathFactsText.setText(R.string.q);
                break;case 18:mathFactsText.setText(R.string.r);
                break;case 19:mathFactsText.setText(R.string.s);
                break;case 20:mathFactsText.setText(R.string.t);
                break;case 21:mathFactsText.setText(R.string.u);
                break;case 22:mathFactsText.setText(R.string.v);
                break;case 23:mathFactsText.setText(R.string.w);
                break;case 24:mathFactsText.setText(R.string.x);
                break;case 25:mathFactsText.setText(R.string.y);
                break;case 26:mathFactsText.setText(R.string.z);
        }


    }
}
