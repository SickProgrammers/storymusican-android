package org.sickprogrammer.storymusican.register;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.login.LoginActivity;
import org.sickprogrammer.storymusican.splash.SplashActivity;

import java.util.Objects;

/**
 * 회원가입이 완료된 경우 표시되는 프래그먼트
 * 정해진 시간 후 해당 프래그먼트를 담당하는 액티비티를 종료시킨다.
 */
public class RegisterCompleteFragment extends Fragment {


    public RegisterCompleteFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //2.5초 뒤에 회원가입 액티비티를 종료시킨다.
        new Handler().postDelayed(() -> {
            requireActivity().finish();
            requireActivity().overridePendingTransition(R.anim.all_slide_enter,R.anim.all_slide_exit);
        },2500);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_register_complete, container, false);
    }
}