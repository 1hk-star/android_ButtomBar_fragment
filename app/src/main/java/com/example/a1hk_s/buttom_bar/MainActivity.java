package com.example.a1hk_s.buttom_bar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private android.support.v4.app.Fragment frag1_home;
    private android.support.v4.app.Fragment frag2_wargame;
    private android.support.v4.app.Fragment frag3_community;
    private android.support.v4.app.Fragment frag4_mypage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            //FragmentManager fm = getFragmentManager();
            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
            //FragmentTransaction fragmentTransaction = fm.beginTransaction();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.frame_layout, frag1_home);
                    break;
                case R.id.navigation_wargame:
                    fragmentTransaction.replace(R.id.frame_layout, frag2_wargame);
                    break;
                case R.id.navigation_community:
                    fragmentTransaction.replace(R.id.frame_layout, frag3_community);
                    break;
                case R.id.navigation_mypage:
                    fragmentTransaction.replace(R.id.frame_layout, frag4_mypage);
                    break;
            }
            fragmentTransaction.commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        frag1_home = new frag1_home();
        frag2_wargame = new frag2_wargame();
        frag3_community = new frag3_community();
        frag4_mypage = new frag4_mypage();

        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout,frag1_home).commit();
    }

}
