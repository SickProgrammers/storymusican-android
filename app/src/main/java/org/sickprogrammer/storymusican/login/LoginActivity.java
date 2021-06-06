package org.sickprogrammer.storymusican.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.customview.CustomRoundButton;
import org.sickprogrammer.storymusican.main.MainActivity;
import org.sickprogrammer.storymusican.register.RegisterActivity;
import org.sickprogrammer.storymusican.utility.DrawableManager;
import org.sickprogrammer.storymusican.utility.ScreenManager;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    Button buttonRegister;
    ImageButton imageButtonPasswordVisibility;
    CustomRoundButton customRoundButtonLogin;
    EditText editTextEmail, editTextPassword;
    MotionLayout motionLayout;
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
        customRoundButtonLogin = findViewById(R.id.customroundbutton_login_login);
        motionLayout = findViewById(R.id.motionlayout_login);
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

        /*
        로그인 성공 시 Transition 발생, Transition 끝난 후 Main Activity 로 이동함
         */
        //TODO:로그인 기능 구현 후, 성공 여부에 따라 Transition 발생하게 수정해야 함
        customRoundButtonLogin.setOnClickListener(v -> {
                    if (true) {
                        motionLayout.setTransition(R.id.transition_login_go_to_main);
                        motionLayout.transitionToEnd();
                        motionLayout.addTransitionListener(new MotionLayout.TransitionListener() {
                            @Override
                            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {

                            }

                            @Override
                            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {

                            }

                            @Override
                            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
                                Intent intentGoToMain = new Intent(LoginActivity.this, MainActivity.class);
                                intentGoToMain.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                                startActivity(intentGoToMain);
                            }

                            @Override
                            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

                            }
                        });
                    }
                    else{

                    }
                }
        );

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