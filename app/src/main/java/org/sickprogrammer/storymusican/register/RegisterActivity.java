package org.sickprogrammer.storymusican;

import androidx.appcompat.app.AppCompatActivity;
import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.ScreenManager;

import android.os.Bundle;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ScreenManager.makeFullScreen(getWindow().getDecorView());
    }
}