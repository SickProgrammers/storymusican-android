package org.sickprogrammer.storymusican.view.login;

import androidx.appcompat.app.AppCompatActivity;
import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.presenter.login.LoginContract;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initFindView();
        initClickListener();
    }

    @Override
    public void initFindView() {

    }

    @Override
    public void initClickListener() {

    }
}