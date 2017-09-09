package teetech.com.g_paypro;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

public class PayBillActivity extends AppCompatActivity
{

    ColorDrawable bgColor;
    LinearLayout main_layout,pay_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_bill);

        main_layout = (LinearLayout) findViewById(R.id.main_layout);
        pay_layout = (LinearLayout) findViewById(R.id.pay_layout);
        pay_layout.setTranslationY(getWindow().getWindowManager().getDefaultDisplay().getHeight());

       if(savedInstanceState==null)
        {

            bgColor = new ColorDrawable(Color.BLACK);
            main_layout.setBackground(bgColor);

            ObjectAnimator bgAnim = ObjectAnimator.ofInt(bgColor, "alpha", 0, 200);
            bgAnim.setDuration(300);
            bgAnim.start();
            bgAnim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation)
                {
                    pay_layout.animate().setDuration(500).translationY(0).setInterpolator(new AccelerateDecelerateInterpolator());
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

        }
    }

    @Override
    public void onBackPressed()
    {
        pay_layout.animate().setDuration(1000).translationY(getWindow().getWindowManager().getDefaultDisplay().getHeight()).setInterpolator(new AnticipateOvershootInterpolator())
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator bgAnim = ObjectAnimator.ofInt(bgColor, "alpha", 0);
                        bgAnim.setDuration(300);
                        bgAnim.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                finish();
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
                        bgAnim.start();

                    }
                });


    }
}
