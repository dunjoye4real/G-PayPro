package teetech.com.g_paypro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by aKI on 11/03/2016.
 */
public class PageViewerAdapter extends FragmentStatePagerAdapter
{
    int NumOfTabs;
    public PageViewerAdapter(FragmentManager fm,int NumOfTabs)
    {
        super(fm);
        this.NumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position) {
            case 0:
                PaymentList tab1 = new PaymentList();
                return tab1;
            case 1:
                ActivityView tab2 = new ActivityView();
                return tab2;

            default:
                return null;
        }

    }

    @Override
    public int getCount()
    {
        return this.NumOfTabs;
    }
}
