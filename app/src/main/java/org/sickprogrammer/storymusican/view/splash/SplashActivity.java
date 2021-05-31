package org.sickprogrammer.storymusican.view.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.sickprogrammer.storymusican.R;
import org.sickprogrammer.storymusican.presenter.BaseContract;
import org.sickprogrammer.storymusican.view.login.LoginActivity;
import org.sickprogrammer.storymusican.view.main.MainActivity;

public class SplashActivity extends AppCompatActivity implements BaseContract.View {
    static final String TAG = SplashActivity.class.getSimpleName();

    ImageView imageViewSplashNote,imageViewSplashPencil;
    TextView textViewSplashAppName;
    boolean isAnimationPencilComplete = false;
    boolean isAnimationAppNameComplete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_temp);

        initFindView();
        imageViewSplashNote.post(new Runnable() {
            @Override
            public void run() {
                startRevealAnimationFromTopLeft(imageViewSplashNote);
            }
        });


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
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           Intent intentGoToLoginActivity = new Intent(SplashActivity.this, LoginActivity.class);
                           intentGoToLoginActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                           startActivity(intentGoToLoginActivity);
                       }
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