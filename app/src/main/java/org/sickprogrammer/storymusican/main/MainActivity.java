package org.sickprogrammer.storymusican.main;

import androidx.appcompat.app.AppCompatActivity;
import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.setting.SettingActivity;
import org.sickprogrammer.storymusican.utility.ScreenManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;


import nl.joery.animatedbottombar.AnimatedBottomBar;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    AnimatedBottomBar animatedBottomBar;
    ImageButton imageButtonSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenManager.makeFullScreen(getWindow().getDecorView());
        setContentView(R.layout.activity_main);
        initFindView();
        initClickListener();
    }

    @Override
    public void initFindView() {
        animatedBottomBar = findViewById(R.id.bottom_navigation_view_main);
        animatedBottomBar.setOnApplyWindowInsetsListener(null);
        imageButtonSetting = findViewById(R.id.imagebutton_main_setting);
    }

    @Override
    public void initClickListener() {
        imageButtonSetting.setOnClickListener(v->{
            Intent intentGoToSettingActivity = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intentGoToSettingActivity);
            overridePendingTransition(R.anim.all_slide_to_top,R.anim.all_stay);
        });


    }


}