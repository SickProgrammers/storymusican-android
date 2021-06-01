package org.sickprogrammer.storymusican.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.sickprogrammer.storymusican.BaseContract;
import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.utility.ScreenManager;
import org.sickprogrammer.storymusican.login.LoginActivity;

public class SplashActivity extends AppCompatActivity implements BaseContract.View {

    ImageView imageViewSplashNote,imageViewSplashPencil;
    TextView textViewSplashAppName;
    boolean isAnimationPencilComplete = false;
    boolean isAnimationAppNameComplete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_temp);
        ScreenManager.makeFullScreen(getWindow().getDecorView());
        initFindView();
        imageViewSplashNote.post(() -> startRevealAnimationFromTopLeft(imageViewSplashNote));


    }

    @Override
    public void initFindView(){
        imageViewSplashNote = findViewById(R.id.imageview_splash_note);
        imageViewSplashPencil = findViewById(R.id.imageview_splash_pencil);
        textViewSplashAppName= findViewById(R.id.textview_splash_appname);
        imageViewSplashNote.setVisibility(View.INVISIBLE);
        imageViewSplashPencil.setVisibility(View.INVISIBLE);
        textViewSplashAppName.setVisibility(View.INVISIBLE);
    }

    @Override
    public void initClickListener() {

    }

    public void startRevealAnimationFromTopLeft(View view){

        int radius = (int) Math.hypot(view.getWidth(),view.getHeight());
        Animator revealAnimator = ViewAnimationUtils
                .createCircularReveal(view, 0, 0, 0 , radius);
        revealAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
               if(!isAnimationPencilComplete){
                   startRevealAnimationFromTopLeft(imageViewSplashPencil);
                   isAnimationPencilComplete=true;
               }
               else if(!isAnimationAppNameComplete){
                   startRevealAnimationFromTopLeft(textViewSplashAppName);
                   isAnimationAppNameComplete = true;
               }
               else {
                   new Handler().postDelayed(() -> {
                       Intent intentGoToLoginActivity = new Intent(SplashActivity.this, LoginActivity.class);
                       intentGoToLoginActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                       startActivity(intentGoToLoginActivity);
                   },1500);

               }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        revealAnimator.setDuration(700);
        view.setVisibility(View.VISIBLE);
        revealAnimator.start();
    }

}