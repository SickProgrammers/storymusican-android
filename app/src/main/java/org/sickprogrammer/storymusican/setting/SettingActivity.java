package org.sickprogrammer.storymusican.setting;

import androidx.appcompat.app.AppCompatActivity;

import org.sickprogrammer.storymusican.BuildConfig;
import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.utility.ScreenManager;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity implements SettingContract.View{
    TextView textViewCurrentVersion;
    ImageButton imageButtonClose;
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
        imageButtonClose = findViewById(R.id.imagebutton_setting_close);
    }

    @Override
    public void initClickListener() {
        imageButtonClose.setOnClickListener(v->{
            finish();
            overridePendingTransition(R.anim.all_stay,R.anim.all_slide_to_bottom);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.all_stay,R.anim.all_slide_to_bottom);
    }
}