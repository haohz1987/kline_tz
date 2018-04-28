package com.guoziwei.klinelib.chart;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.Transformer;
import com.guoziwei.klinelib.R;
import com.guoziwei.klinelib.model.HisData;
import com.guoziwei.klinelib.util.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

class BaseView extends LinearLayout {

    protected String mDateFormat = "yyyy-MM-dd HH:mm";

    protected int mDecreasingColor;
    protected int mIncreasingColor;
    protected int mAxisColor;
    protected int mTransparentColor;

    public int MAX_COUNT = 150;
    public int MIN_COUNT = 10;
    public int INIT_COUNT = 80;

    protected List<HisData> mData = new ArrayList<>(300);

    public BaseView(Context context) {
        this(context, null);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mAxisColor = ContextCompat.getColor(getContext(), R.color.axis_color);
        mTransparentColor = ContextCompat.getColor(getContext(), android.R.color.transparent);
        mDecreasingColor = ContextCompat.getColor(getContext(), R.color.decreasing_color);
        mIncreasingColor = ContextCompat.getColor(getContext(), R.color.increasing_color);
    }

    protected void initBottomChart(AppCombinedChart chart) {
        chart.setScaleEnabled(true);
        chart.setDrawBorders(false);
        chart.setBorderWidth(1);
        //可以拖拽
        chart.setDragEnabled(true);
        //Y方向按比例缩减
        chart.setScaleYEnabled(false);
        //设置自动缩小放大
        chart.setAutoScaleMinMaxEnabled(true);
        //移动减速
        chart.setDragDecelerationEnabled(false);
        //设置选中高亮
        chart.setHighlightPerDragEnabled(false);
        Legend lineChartLegend = chart.getLegend();
        lineChartLegend.setEnabled(false);

        XAxis xAxisVolume = chart.getXAxis();
        xAxisVolume.setDrawLabels(true);
        xAxisVolume.setDrawAxisLine(false);
        xAxisVolume.setDrawGridLines(false);
        xAxisVolume.setTextColor(mAxisColor);
        //设置时间提示的位置/数量
        xAxisVolume.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxisVolume.setLabelCount(5, true);
        xAxisVolume.setAvoidFirstLastClipping(true);
        xAxisVolume.setAxisMinimum(-0.5f);

        xAxisVolume.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (mData.isEmpty()) {
                    return "";
                }
                if (value < 0) {
                    value = 0;
                }
                if (value < mData.size()) {
                    return DateUtils.formatDate(mData.get((int) value).getDate(), mDateFormat);
                }
                return "";
            }
        });

        YAxis axisLeftVolume = chart.getAxisLeft();
        axisLeftVolume.setDrawLabels(true);
        axisLeftVolume.setDrawGridLines(false);
        //成交量提示的数量
        axisLeftVolume.setLabelCount(3, true);
        axisLeftVolume.setDrawAxisLine(false);
        axisLeftVolume.setTextColor(mAxisColor);

        axisLeftVolume.setSpaceTop(15);
        axisLeftVolume.setSpaceBottom(0);
        axisLeftVolume.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);//左侧成交量提示

        Transformer leftYTransformer = chart.getRendererLeftYAxis().getTransformer();
        ColorContentYAxisRenderer leftColorContentYAxisRenderer = new ColorContentYAxisRenderer(chart.getViewPortHandler(), chart.getAxisLeft(), leftYTransformer);
        leftColorContentYAxisRenderer.setLabelInContent(true);
        leftColorContentYAxisRenderer.setUseDefaultLabelXOffset(false);
        chart.setRendererLeftYAxis(leftColorContentYAxisRenderer);
        //右边y
        YAxis axisRightVolume = chart.getAxisRight();
        axisRightVolume.setDrawLabels(false);
        axisRightVolume.setLabelCount(3,true);
        //成交量网格线
        axisRightVolume.setDrawGridLines(true);
        axisRightVolume.setDrawAxisLine(false);

    }


    protected void moveToLast(AppCombinedChart chart) {
        if (mData.size() > INIT_COUNT) {
            chart.moveViewToX(mData.size() - INIT_COUNT);
        }
    }

    /**
     * set the count of k chart
     */
    public void setCount(int init, int max, int min) {
        INIT_COUNT = init;
        MAX_COUNT = max;
        MIN_COUNT = min;
    }

    protected void setDescription(Chart chart, String text) {
        Description description = chart.getDescription();
//        float dx = chart.getWidth() - chart.getViewPortHandler().offsetRight() - description.getXOffset();
//        description.setPosition(dx, description.getTextSize());
        description.setText(text);
    }

    public HisData getLastData() {
        if (mData != null && !mData.isEmpty()) {
            return mData.get(mData.size() - 1);
        }
        return null;
    }

    public void setDateFormat(String mDateFormat) {
        this.mDateFormat = mDateFormat;
    }
}
