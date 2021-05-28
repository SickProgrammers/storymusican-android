package org.sickprogrammer.storymusican.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableCompat;

import org.sickprogrammer.storymusican.R;

public class CustomRoundButton extends ConstraintLayout {

    View background;
    TextView buttonText;
    public CustomRoundButton(@NonNull Context context) {
        super(context);
        initView();
    }

    public CustomRoundButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
        getAttrs(attrs);
    }

    public CustomRoundButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        getAttrs(attrs,defStyleAttr);
    }


    private void initView(){
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(infService);
        View view = layoutInflater.inflate(R.layout.all_customview_roundedbutton,this,false);
        addView(view);
        buttonText = findViewById(R.id.textview_custombutton_text);
        background = findViewById(R.id.view_custombutton_background);

    }
    private void getAttrs(AttributeSet attributeSet){
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet,R.styleable.CustomRoundButton);

        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attributeSet,int defStyle){
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet,R.styleable.CustomRoundButton,defStyle,0);
        setTypeArray(typedArray);
    }


    private void setTypeArray(TypedArray typedArray){
        String text = typedArray.getString(R.styleable.CustomRoundButton_text);
        int buttonColor = typedArray.getColor(R.styleable.CustomRoundButton_buttonColor,0);
        int textColor = typedArray.getColor(R.styleable.CustomRoundButton_textColor,0);

        Drawable buttonDrawable = background.getBackground();
        buttonDrawable = DrawableCompat.wrap(buttonDrawable);
        DrawableCompat.setTint(buttonDrawable,buttonColor);
        background.setBackground(buttonDrawable);
        buttonText.setText(text);
        buttonText.setTextColor(textColor);
    }
}
