package org.sickprogrammer.storymusican.view.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.view.main.MainActivity;

public class SplashActivity extends AppCompatActivity {
    static final String TAG = SplashActivity.class.getSimpleName();
    boolean isStart = false;
    boolean isStart2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MotionLayout motionLayout = findViewById(R.id.motion_splash);
        View constraintLayout = findViewById(R.id.temp);
        View temp = findViewById(R.id.view_splash_background);
        temp.setVisibility(View.INVISIBLE);
        constraintLayout.setVisibility(View.INVISIBLE);
        motionLayout.addTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {


            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
                if(v>0.55&&!isStart) {
                    initBackground(temp);
                    isStart = true;
                }
                if(v>0.0&&!isStart2){
                    initBackground2(constraintLayout);
                    isStart2 = true;
                }

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

            }
        });
    }

    public void initBackground(View view){
        int centerX=(int) view.getWidth()/2;
        int centerY=(int) view.getHeight()/2;

        int radius = (int) Math.hypot(view.getWidth(),view.getHeight());
        Animator revealAnimator = ViewAnimationUtils
            .createCircularReveal(view, 0, 0, 0 , radius);
        revealAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(isStart)
                {
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        revealAnimator.setDuration(1200);
        revealAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setVisibility(View.VISIBLE);
        revealAnimator.start();
    }
    public void initBackground2(View view){
        int centerX=(int) view.getWidth()/2;
        int centerY=(int) view.getHeight()/2;

        int radius = (int) Math.hypot(view.getWidth(),view.getHeight());
        Animator revealAnimator = ViewAnimationUtils
                .createCircularReveal(view, 0, 0, radius , 0);
        revealAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        revealAnimator.setDuration(1200);
        revealAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setVisibility(View.VISIBLE);
        revealAnimator.start();
    }
}