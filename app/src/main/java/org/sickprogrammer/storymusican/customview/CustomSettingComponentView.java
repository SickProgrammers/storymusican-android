package org.sickprogrammer.storymusican.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.sickprogrammer.storymusican.R;

public class CustomSettingComponentView extends LinearLayout {
    ImageView imageViewSettingComponent;
    TextView textViewSettingComponent;
    TextView textViewOption;

    public CustomSettingComponentView(Context context) {
        super(context);
        initView();
    }

    public CustomSettingComponentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
        getAttrs(attrs);

    }

    public CustomSettingComponentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        getAttrs(attrs,defStyleAttr);

    }
    private void initView(){
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(infService);
        View view = layoutInflater.inflate(R.layout.all_customview_settingcomponent,this,false);
        addView(view);
        textViewSettingComponent = findViewById(R.id.textview_customview_settingcomponent);
        imageViewSettingComponent = findViewById(R.id.imageview_customview_settingcomponent);
        textViewOption = findViewById(R.id.textview_customview_settingcomponent_option);
    }
    private void getAttrs(AttributeSet attributeSet){
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet,R.styleable.CustomSettingComponentView);

        setTypeArray(typedArray);
    }
    private void getAttrs(AttributeSet attributeSet,int defStyle){
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet,R.styleable.CustomSettingComponentView,defStyle,0);
        setTypeArray(typedArray);
    }
    private void setTypeArray(TypedArray typedArray){
        String text = typedArray.getString(R.styleable.CustomSettingComponentView_text_setting_component);
        Drawable drawable = typedArray.getDrawable(R.styleable.CustomSettingComponentView_android_src);
        boolean optionVisibility = typedArray.getBoolean(R.styleable.CustomSettingComponentView_optionVisibility,false);
        if(optionVisibility)
            textViewOption.setVisibility(VISIBLE);
        else
            textViewOption.setVisibility(INVISIBLE);
        textViewSettingComponent.setText(text);
        imageViewSettingComponent.setImageDrawable(drawable);

    }
}
