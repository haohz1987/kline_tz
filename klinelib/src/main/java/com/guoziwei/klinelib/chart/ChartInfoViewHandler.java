package com.guoziwei.klinelib.chart;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.highlight.Highlight;
import com.guoziwei.klinelib.LogT;

/**
 * Created by dell on 2017/10/27.
 */

public class ChartInfoViewHandler implements View.OnTouchListener {

    private BarLineChartBase mChart;
    private final GestureDetector mDetector;

    private boolean mIsLongPress = false;

    public ChartInfoViewHandler(BarLineChartBase chart) {
        mChart = chart;
        mDetector = new GestureDetector(mChart.getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
                LogT.w("手势操作,长按_MotionEvent="+e.getAction());
                mIsLongPress = true;
                Highlight h = mChart.getHighlightByTouchPoint(e.getX(), e.getY());
                if (h != null) {
                    mChart.highlightValue(h, true);
                    mChart.disableScroll();
                }
            }

        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        LogT.w("0按下,1抬起,2移动,3,取消_event="+event.getAction()+"");
        mDetector.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
            mIsLongPress = false;
        }
        if (mIsLongPress && event.getAction() == MotionEvent.ACTION_MOVE) {
            LogT.w("长按并移动");
            Highlight h = mChart.getHighlightByTouchPoint(event.getX(), event.getY());
            if (h != null) {
                mChart.highlightValue(h, true);
                mChart.disableScroll();
            }
            return true;
        }
        return false;
    }
}
