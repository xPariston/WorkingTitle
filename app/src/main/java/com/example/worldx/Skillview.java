package com.example.worldx;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Skillview extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView skillA1;
    private TextView skillA2;
    private TextView skillB1;
    private TextView skillB2;
    private TextView XP_skillA1;
    private TextView XP_skillA2;
    private TextView XP_skillB1;
    private TextView XP_skillB2;
    private TextView Level_skillA1;
    private TextView Level_skillA2;
    private TextView Level_skillB1;
    private TextView Level_skillB2;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_warskill);
                    skillA1.setText(R.string.warskill_woodspear);
                    skillB1.setText(R.string.warskill_stonethrower);

                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_workskill);
                    skillA1.setText(R.string.workskill_Wood);
                    skillA2.setText(R.string.workskill_Planks);
                    skillB1.setText(R.string.workskill_Stone);
                    skillB2.setText(R.string.workskill_Bricks);

                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_travelskill);
                    skillA1.setText(R.string.travelskill_foodstorage);
                    skillB1.setText(R.string.travelskill_footspeed);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skillview);

        mTextMessage = (TextView) findViewById(R.id.message);
        skillA1 = (TextView) findViewById(R.id.SkillA1);
        skillA2 = (TextView) findViewById(R.id.skillA2);
        skillB1 = (TextView) findViewById(R.id.SkillB1);
        skillB2 = (TextView) findViewById(R.id.skillB2);

        XP_skillA1 = (TextView) findViewById(R.id.xpSkillA1);
        XP_skillA2 = (TextView) findViewById(R.id.xpSkillA2);
        XP_skillB1 = (TextView) findViewById(R.id.xpSkillB1);
        XP_skillB2 = (TextView) findViewById(R.id.xpSkillB1);

        Level_skillA1 = (TextView) findViewById(R.id.skillLevelA1);
        Level_skillA2 = (TextView) findViewById(R.id.skillLevelA2);
        Level_skillB1 = (TextView) findViewById(R.id.skillLevelB1);
        Level_skillB2 = (TextView) findViewById(R.id.skillLevelB2);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
