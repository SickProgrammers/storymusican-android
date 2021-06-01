package org.sickprogrammer.storymusican.utility;

import android.view.View;

/**
 * 어플리케이션 화면을 관리하는 매니저 클래스
 */
public class ScreenManager {

    /**
     * 상태바, 네비게이션 바를 숨기고 전체화면을 만드는 함수
     * @param view 전체화면을 적용할 뷰 (getWindow().getDecorView())
     */
    public static void makeFullScreen(View view){
        view.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE|
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}
