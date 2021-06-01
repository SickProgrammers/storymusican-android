package org.sickprogrammer.storymusican.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.customview.CustomRoundButton;
import org.sickprogrammer.storymusican.utility.ScreenManager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * 회원가입 액티비티 입니다.
 */
public class RegisterActivity extends AppCompatActivity implements RegisterContract.View{
    ImageButton imageButtonBack;
    CustomRoundButton customRoundButtonNext;
    ArrayList<Fragment> registerInfoFragments = new ArrayList<>();
    int currentIndex = 0;
    FragmentManager registerInfoFragmentManager;
    FrameLayout registerInfoFragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ScreenManager.makeFullScreen(getWindow().getDecorView());
        initFindView();
        initClickListener();
        createFragment();
        initFragment();

    }

    @Override
    public void initFindView() {
        imageButtonBack = findViewById(R.id.imagebutton_register_back);
        customRoundButtonNext = findViewById(R.id.customroundbutton_register_next);
        registerInfoFragmentContainer = findViewById(R.id.framelayout_register_fragment);
    }

    @Override
    public void initClickListener() {
        imageButtonBack.setOnClickListener(v->moveToPreviousFragment());
        customRoundButtonNext.setOnClickListener(v->moveToNextFragment());
    }

    /**
     * REGISTERINFO 열거형에 존재하는 타입에 기반한 프래그먼트를 생성하는 함수
     */
    @Override
    public void createFragment() {
        for(REGISTERINFO type:REGISTERINFO.values()){
            registerInfoFragments.add(new RegisterInfoFragment(type));
        }
    }

    /**
     * 다음 유저 정보를 입력받을 프래그먼트로 이동하는 함수, 모든 정보 입력이 끝난 경우 회원가입을 시도한다.
     */

    //TODO:다음 프래그먼트로 넘어갈 때마다 해당 프래그먼트가 관리하는 유저정보가 유효한지 확인한 뒤에 넘어가도록 구현해야함
    //TODO:모든 유저 정보 입력이 끝난 경우 회원가입 시도 후 성공 시 회원가입 완료 프래그먼트로 이동해야함
    @Override
    public void moveToNextFragment() {
        if(currentIndex<registerInfoFragments.size()-1){
            FragmentTransaction registerInfoFragmentTransaction = registerInfoFragmentManager.beginTransaction();
            registerInfoFragmentTransaction.setCustomAnimations(R.anim.all_slide_in,R.anim.all_slide_out);
            registerInfoFragmentTransaction.replace(registerInfoFragmentContainer.getId(),registerInfoFragments.get(++currentIndex));
            registerInfoFragmentTransaction.commit();
        }

    }

    @Override
    public void moveToPreviousFragment() {
        if(currentIndex>0){
            FragmentTransaction registerInfoFragmentTransaction = registerInfoFragmentManager.beginTransaction();
            registerInfoFragmentTransaction.setCustomAnimations(R.anim.all_slide_enter,R.anim.all_slide_exit);
            registerInfoFragmentTransaction.replace(registerInfoFragmentContainer.getId(),registerInfoFragments.get(--currentIndex));
            registerInfoFragmentTransaction.commit();
        }
        else {
            finish();
            overridePendingTransition(R.anim.all_slide_enter,R.anim.all_slide_exit);
        }
    }


    //TODO:유저 모델 생성 후 회원가입 정보 관리 필요
    /**
     * 프래그먼트로부터 회원가입 정보를 얻어오는 함수
     */
    @Override
    public void getRegisterInfoFromFragment() {

    }


    /**
     * 첫 액티비티 실행 시 첫번째 RegisterInfo 프래그먼트를 뷰에 설정하기 위한 함수입니다.
     */
    @Override
    public void initFragment() {
        registerInfoFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= registerInfoFragmentManager.beginTransaction();
        fragmentTransaction.replace(registerInfoFragmentContainer.getId(),registerInfoFragments.get(0));
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.all_slide_enter,R.anim.all_slide_exit);
    }
}