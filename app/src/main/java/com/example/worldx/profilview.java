package com.example.worldx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class profilview extends AppCompatActivity {

    Button btn_warskills;
    Button btn_workskills;
    Button btn_travelskills;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_warskills = (Button) findViewById(R.id.btn_warskills);
        btn_workskills = (Button) findViewById(R.id.btn_workskills);
        btn_travelskills = (Button) findViewById(R.id.btn_travelskills);

        btn_warskills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSkillview();
            }
        });

        btn_workskills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSkillview();
            }
        });

        btn_travelskills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSkillview();
            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void openSkillview()
    {
        Intent intent = new Intent(this,Skillview.class);
        startActivity(intent);
    }
}
