package teetech.com.g_paypro;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

/**
 * Created by aKI on 11/03/2016.
 */
public class ActivityView extends android.support.v4.app.Fragment implements OnChartGestureListener, OnChartValueSelectedListener
{
    LineChart chart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
       View view =  inflater.inflate(R.layout.activity_view_layout, container, false);
       chart = (LineChart) view.findViewById(R.id.line_chart);

        chart.setOnChartGestureListener(this);
        chart.setOnChartValueSelectedListener(this);
        chart.setDrawGridBackground(false);

        // no description text
        chart.setDescription("");
        chart.setNoDataTextDescription("You need to provide data for the chart.");

        // enable touch gestures
        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);
        // mChart.setScaleXEnabled(true);
        // mChart.setScaleYEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(true);



        /*LimitLine llXAxis = new LimitLine(10f, "Index 10");
        llXAxis.setLineWidth(4f);
        llXAxis.setLineColor(Color.MAGENTA);
        llXAxis.disableDashedLine();
        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        llXAxis.setTextSize(10f);*/


        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);

        /*LimitLine ll1 = new LimitLine(130f, "Upper Limit");
        ll1.setLineWidth(4f);
        //ll1.enableDashedLine(10f, 10f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        ll1.setTextSize(10f);


        LimitLine ll2 = new LimitLine(-30f, "Lower Limit");
        ll2.setLineWidth(4f);
        ll2.enableDashedLine(10f, 10f, 0f);
        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        ll2.setTextSize(10f);*/


        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        //leftAxis.addLimitLine(ll1);
        //leftAxis.addLimitLine(ll2);
        leftAxis.setAxisMaxValue(4000*5);
        leftAxis.setAxisMinValue(0);
        //leftAxis.setYOffset(20f);
        //leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawGridLines(false);
        leftAxis.setDrawZeroLine(false);

        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);

       // chart.getAxisRight().setEnabled(false);

        chart.animateX(2500, Easing.EasingOption.EaseInOutQuart);

        setData(5, 1000);


        return view;
    }

    private void setData(int count, float range) {

        ArrayList<String> xVals = new ArrayList<String>();
        ArrayList<String> month = new ArrayList<String>();
        month.add("Jan");
        month.add("feb");
        month.add("mar");
        month.add("apr");
        month.add("may");

        for (int i = 0; i < count; i++)
        {
            xVals.add(month.get(i));
        }

        ArrayList<Entry> yVals = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {

            float val = (float) 4000*i;
            // ((mult *
            // 0.1) / 10);
            yVals.add(new Entry(val, i));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(yVals, "DataSet 1");
         set1.setFillAlpha(110);
        set1.setFillColor(Color.RED);

        // set the line to be drawn like this "- - - - - -"
        //set1.enableDashedLine(10f, 5f, 0f);
        //set1.enableDashedHighlightLine(10f, 5f, 0f);


        set1.setColor(Color.RED);
        set1.setHighlightEnabled(true);
        set1.setHighlightLineWidth(2f);
        set1.setHighLightColor(Color.BLUE);
        set1.setCircleColor(R.color.colorAccent);
        set1.setLineWidth(5f);
        set1.setCircleRadius(0f);
        set1.setDrawCircleHole(true);
        set1.setValueTextSize(14f);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.color.colorPrimary);
        set1.setFillDrawable(drawable);
        set1.setDrawFilled(true);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(xVals, dataSets);

        // set data
        chart.setData(data);
    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me)
    {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onStart()
    {
        chart.animateY(1500, Easing.EasingOption.EaseInOutBounce);
        super.onStart();
    }
}
