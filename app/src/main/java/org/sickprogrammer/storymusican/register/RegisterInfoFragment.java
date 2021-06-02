package org.sickprogrammer.storymusican.register;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.utility.DrawableManager;

import java.util.Objects;

/**
 * 회원가입 정보 입력 뷰를 담당하는 프래그먼트
 */
public class RegisterInfoFragment extends Fragment implements RegisterFragmentContract.View {
    static final String TAG = RegisterInfoFragment.class.getSimpleName();
    TextView textViewTitle;
    EditText editTextRegisterInfo;
    ImageButton imageButtonPasswordVisibility;
    boolean isPasswordShown = false;

    /**
     * 현재 프래그먼트가 무슨 회원가입 정보를 입력 받는 중인지 나타내는 타입
     */
    REGISTERINFO type;

    /**
     * 각 회원가입 정보를 입력받는 프래그먼트로 생성자에선 REGISTERINFO 열거형의 한 타입을 받습니다.
     *
     * @param type 프래그먼트가 입력받을 회원정보
     */
    public RegisterInfoFragment(REGISTERINFO type) {
        this.type = type;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_info, container, false);
        initFindView(view);
        initClickListener();
        setTitleAndEditTextWithType(type);
        return view;
    }

    @Override
    public void initFindView(View view) {
        textViewTitle = view.findViewById(R.id.textview_register_title);
        editTextRegisterInfo = view.findViewById(R.id.edittext_register_info);
        imageButtonPasswordVisibility = view.findViewById(R.id.imagebutton_register_password_visibility);
    }

    @Override
    public void initClickListener() {
        /*
        비밀번호 보기설정 버튼 리스너,
        비밀번호 보기 여부를 토글하고,
        비밀번호 보기설정 이미지 버튼의 색상을 변경한다.
         */
        imageButtonPasswordVisibility.setOnClickListener(v -> {
            if (isPasswordShown) {
                DrawableManager.setImageTint(imageButtonPasswordVisibility, requireActivity().getColor(R.color.all_Disabled_color));
            } else {
                DrawableManager.setImageTint(imageButtonPasswordVisibility, requireActivity().getColor(R.color.black));
            }
            isPasswordShown = togglePassWordVisibility(isPasswordShown, editTextRegisterInfo);
        });
    }

    /**
     * REGISTERINFO 열거형의 타입에 따라 타이틀과 editText 의 속성값을 설정하는 함수입니다.
     *
     * @param type 현재 프래그먼트의 타입
     */
    @Override
    public void setTitleAndEditTextWithType(REGISTERINFO type) {
        switch (type) {
            /*
            EMAIL 타입에 맞는 타이틀을 설정, editText의 inputType 을 email로 설정한다.
             */
            case EMAIL:
                textViewTitle.setText(getString(R.string.register_input_email));
                editTextRegisterInfo.setHint(getString(R.string.all_email));
                editTextRegisterInfo.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                imageButtonPasswordVisibility.setVisibility(View.INVISIBLE);
                break;
            /*
            PASSWORD 타입에 맞는 타이틀을 설정, editText의 inputType 을 PASSWORD 로 설정한다.
             */
            case PASSWORD:
                textViewTitle.setText(getString(R.string.register_input_password));
                editTextRegisterInfo.setHint(getString(R.string.all_password));
                editTextRegisterInfo.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                editTextRegisterInfo.setTransformationMethod(PasswordTransformationMethod.getInstance());
                imageButtonPasswordVisibility.setVisibility(View.VISIBLE);
                break;
        }
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