package com.example.anuda.mathapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.anuda.mathapp.quadratics.QuadraticEquationsActivity;

public class QuadraticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratics);

        TextView quadTitle= (TextView) findViewById(R.id.title_text);

        Button solveQuadEqns = (Button) findViewById(R.id.solveQuadEqns);
        solveQuadEqns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNew = new Intent(QuadraticsActivity.this, QuadraticEquationsActivity.class);
                startActivity(intentNew);
            }
        });
    }
}
