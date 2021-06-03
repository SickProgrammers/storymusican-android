package org.sickprogrammer.storymusican.utility;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.core.graphics.drawable.DrawableCompat;

/**
 * Drawable 요소들을 코드상으로 관리하는 객체
 */
public class DrawableManager {


    /**
     * 백그라운드 drawable의 색상 값을 변경하는 함수
     * @param setTo svg 요소의 색상 값을 변경할 뷰
     * @param color 변경할 색상
     */
    public static void setBackgroundTint(View setTo, int color){
        Drawable viewDrawable = setTo.getBackground();
        if(viewDrawable!=null) {
            viewDrawable = DrawableCompat.wrap(viewDrawable);
            DrawableCompat.setTint(viewDrawable, color);
            setTo.setBackground(viewDrawable);
        }
    }

    /**
     * drawable의 색상 값을 변경하는 함수
     * @param setTo 색상 값을 변경할 뷰
     * @param color 변경할 색
     */
    public static void setImageTint(View setTo,int color){
        if(setTo instanceof ImageView) {
            ((ImageView)setTo).setColorFilter(color);
        }
    }
}
