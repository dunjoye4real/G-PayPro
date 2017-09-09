package teetech.com.g_paypro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * Created by aKI on 11/03/2016.
 */
public class PaymentList extends android.support.v4.app.Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.payment_list_layout, container, false);
    }
}
