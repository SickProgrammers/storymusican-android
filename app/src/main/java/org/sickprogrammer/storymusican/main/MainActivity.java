package org.sickprogrammer.storymusican.main;

import androidx.appcompat.app.AppCompatActivity;
import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.utility.ScreenManager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    AnimatedBottomBar animatedBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenManager.makeFullScreen(getWindow().getDecorView());
        setContentView(R.layout.activity_main);
        initFindView();
    }

    @Override
    public void initFindView() {
        animatedBottomBar = findViewById(R.id.bottom_navigation_view_main);
        animatedBottomBar.setOnApplyWindowInsetsListener(null);
    }

    @Override
    public void initClickListener() {

    }


}