package teetech.com.g_paypro;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout pay_drawer;
    Button pay_button;
    LinearLayout main_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null)
        {

        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Payment List"));
        tabLayout.addTab(tabLayout.newTab().setText("Activity View"));
        main_layout = (LinearLayout)findViewById(R.id.main_layout);

        pay_button = (Button)findViewById(R.id.pay_button);
        pay_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(v.getId()==R.id.pay_button)
                {
                    pay_button.animate().setInterpolator(new AccelerateInterpolator()).setDuration(500).translationY(getWindowManager().getDefaultDisplay().getHeight())
                            .withEndAction(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(MainActivity.this, PayBillActivity.class);

                                    startActivity(i);
                                    overridePendingTransition(0, 0);
                                }
                            });

                }
            }
        });

        if(savedInstanceState!=null)
        {
            pay_button.animate().translationY(0).setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator());
        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        pay_drawer = (LinearLayout) findViewById(R.id.pay_drawer);



        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PageViewerAdapter adapter = new PageViewerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new ViewPagerTransformer());


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
       // pay_drawer.setAlpha(0.0f);

    }

    @Override
    public void onResume()
    {
        pay_button.animate().translationY(0).setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator());
        super.onResume();
    }
}
