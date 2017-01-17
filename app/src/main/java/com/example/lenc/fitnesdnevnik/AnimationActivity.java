package com.example.lenc.fitnesdnevnik;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity implements Animation.AnimationListener{
    Button btnStart;
    TextView text;
    ImageView ena, dva, tri;
    Animation animTxt, animEna, animDva, animTri, animRunner, animEnaOut, animDvaOut, animTriOut, animButton, animTextDown;
    GifView runner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        runner=(GifView)findViewById(R.id.gif_view);
        ena=(ImageView)findViewById(R.id.imageView1);
        dva=(ImageView)findViewById(R.id.imageView2);
        tri=(ImageView)findViewById(R.id.imageView3);
        text=(TextView)findViewById(R.id.textViewNapis);
        btnStart=(Button)findViewById(R.id.buttonStart);

        text.setVisibility(View.INVISIBLE);
        ena.setVisibility(View.INVISIBLE);
        dva.setVisibility(View.INVISIBLE);
        tri.setVisibility(View.INVISIBLE);
        runner.setVisibility(View.INVISIBLE);
        btnStart.setVisibility(View.INVISIBLE);

        animTxt = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_text);
        animTri = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animTriOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        animDva = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animDvaOut=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        animEna = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animEnaOut=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        animRunner=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_runner);
        animTextDown=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_text_down);

        animTri.setAnimationListener(this);
        animTriOut.setAnimationListener(this);
        animDva.setAnimationListener(this);
        animDvaOut.setAnimationListener(this);
        animEna.setAnimationListener(this);
        animEnaOut.setAnimationListener(this);
        animRunner.setAnimationListener(this);

        tri.setImageResource(R.drawable.prenos2);
        dva.setImageResource(R.drawable.prenos1);
        ena.setImageResource(R.drawable.prenos);

                text.setVisibility(View.VISIBLE);
                text.startAnimation(animTxt);
                tri.setVisibility(View.VISIBLE);
                tri.startAnimation(animTri);
                tri.setVisibility(View.INVISIBLE);
                tri.startAnimation(animTriOut);
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        dva.setVisibility(View.VISIBLE);
                        dva.startAnimation(animDva);
                        dva.setVisibility(View.INVISIBLE);
                        dva.startAnimation(animDvaOut);
                        new Handler().postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                ena.setVisibility(View.VISIBLE);
                                ena.startAnimation(animEna);
                                ena.setVisibility(View.INVISIBLE);
                                ena.startAnimation(animEnaOut);
                                new Handler().postDelayed(new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        text.startAnimation(animTextDown);
                                        runner.setVisibility(View.VISIBLE);
                                        runner.startAnimation(animRunner);
                                    }
                                }, 1000);
                            }
                        }, 1000);
                    }
                }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(AnimationActivity.this, MainActivity.class);
                AnimationActivity.this.startActivity(mainIntent);
                AnimationActivity.this.finish();
            }
        }, 6000);
            }
    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for fade in animation
       /* if (animation == animFadein) {
            Toast.makeText(getApplicationContext(), "Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }*/

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }
}
