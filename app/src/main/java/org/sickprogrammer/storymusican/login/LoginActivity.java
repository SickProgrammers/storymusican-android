package org.sickprogrammer.storymusican.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.register.RegisterActivity;
import org.sickprogrammer.storymusican.utility.DrawableManager;
import org.sickprogrammer.storymusican.utility.ScreenManager;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    Button buttonRegister;
    ImageButton imageButtonPasswordVisibility;
    EditText editTextEmail, editTextPassword;
    //현재 비밀번호 보기 설정 여부
    boolean isPasswordShown = false;

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
        buttonRegister = findViewById(R.id.button_login_register);
        imageButtonPasswordVisibility = findViewById(R.id.imagebutton_login_password_visibility);
        editTextEmail = findViewById(R.id.edittext_login_id);
        editTextPassword = findViewById(R.id.edittext_login_password);

    }

    @Override
    public void initClickListener() {
        buttonRegister.setOnClickListener(v -> {
            Intent goToRegisterIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(goToRegisterIntent);
            overridePendingTransition(R.anim.all_slide_in, R.anim.all_slide_out);

        });
        imageButtonPasswordVisibility.setOnClickListener(v -> {
            if (isPasswordShown) {
                DrawableManager.setImageTint(imageButtonPasswordVisibility, getColor(R.color.all_Disabled_color));
            } else {
                DrawableManager.setImageTint(imageButtonPasswordVisibility, getColor(R.color.black));
            }
            isPasswordShown = togglePassWordVisibility(isPasswordShown, editTextPassword);
        });
    }

    /**
     * 비밀번호 보기를 토글하는 함수
     *
     * @param isShown 현재 비밀번호의 보기여부
     * @return 토글된 비밀번호 보기여부
     */
    @Override
    public boolean togglePassWordVisibility(boolean isShown, EditText setTo) {
        // 현재 비밀번호가 보이는 경우
        if (isShown) {
            setTo.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        // 현재 비밀번호가 보이지 않는 경우
        else {
            setTo.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        return !isShown;
    }
}