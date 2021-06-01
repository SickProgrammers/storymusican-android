package org.sickprogrammer.storymusican;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ScreenManager.makeFullScreen(getWindow().getDecorView());
        initFindView();
        initClickListener();
    }

    @Override
    public void initFindView() {
        registerButton = findViewById(R.id.button_login_register);
    }

    @Override
    public void initClickListener() {
        registerButton.setOnClickListener(v -> {
            Intent goToRegisterIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(goToRegisterIntent);
        });
    }
}