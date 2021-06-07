package org.sickprogrammer.storymusican.setting;

import androidx.appcompat.app.AppCompatActivity;

import org.sickprogrammer.storymusican.BuildConfig;
import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.utility.ScreenManager;

import android.os.Bundle;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity implements SettingContract.View{
    TextView textViewCurrentVersion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ScreenManager.makeFullScreen(getWindow().getDecorView());
        initFindView();
        initClickListener();
    }


    @Override
    public void initFindView() {
        textViewCurrentVersion = findViewById(R.id.textview_setting_current_version);
        String currentVersion = "현재 버전" + BuildConfig.VERSION_NAME;
        textViewCurrentVersion.setText(currentVersion);
    }

    @Override
    public void initClickListener() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.all_slide_to_top_over,R.anim.all_slide_to_top);
    }
}