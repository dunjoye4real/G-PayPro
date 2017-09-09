package teetech.com.g_paypro;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;

/**
 * Created by aKI on 12/03/2016.
 */
public class ViewPagerTransformer implements ViewPager.PageTransformer
{
    public ViewPagerTransformer()
    {

    }

    @Override
    public void transformPage(View view, float position)
    {
        final float MIN_SCALE = 0.75f;
        int pageWidth = view.getWidth();
        TextView txt = (TextView)view.findViewById(R.id.new_text);


        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        }
        else if (position <= 0)
        { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);
            //txt.setText("from view pager transformer");
            //txt.invalidate();


        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position);

            // Counteract the default slide transition
            view.setTranslationX(pageWidth * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }

        /*float MaxAngle = 30F;
        if (position < -1 || position > 1)
        {
            view.setAlpha(0); // The view is offscreen.
        }
        else
        {
            view.setAlpha(1);

            view.setPivotY(view.getHeight() / 2); // The Y Pivot is halfway down the view.

            // The X pivots need to be on adjacent sides.
            if (position < 0)
            {
                view.setPivotX(view.getWidth());
            }
            else
            {
                view.setPivotX(0);
            }

            view.setPivotY(MaxAngle * position); // Rotate the view.

           // view.FindViewById<TextView> (Resource.Id.textView1).Text = string.Format ("Position: {0}\r\nPivotX: {1}\r\nRotationY {2}", position, view.PivotX, view.RotationY);
        }*/

    }
}
