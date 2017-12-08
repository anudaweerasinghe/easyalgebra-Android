package com.example.anuda.mathapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.anuda.mathapp.linearalgebra.SimultEqnsActivity;
import com.example.anuda.mathapp.quadratics.QuadraticEquationsActivity;

import org.w3c.dom.Text;

public class LinearAlgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_alg);

        TextView lineAlgTitle = (TextView) findViewById(R.id.title_text);

        Button simEqnsBtn = (Button) findViewById(R.id.solvesSimultEqns);

        simEqnsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentNew = new Intent(LinearAlgActivity.this, SimultEqnsActivity.class);
                startActivity(intentNew);
            }
        });



    }
}
