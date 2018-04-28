package com.guoziwei.kline;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoziwei.klinelib.LogT;
import com.guoziwei.klinelib.chart.TimeLineView;
import com.guoziwei.klinelib.model.HisData;

import java.util.List;

/**
 * 分时页面
 */
public class TimeLineChartFragment extends Fragment {


    private TimeLineView mTimeLineView;
    private int mType;

    public TimeLineChartFragment() {
        // Required empty public constructor
    }

    public static TimeLineChartFragment newInstance(int type) {
        TimeLineChartFragment fragment = new TimeLineChartFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt("type");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mTimeLineView = new TimeLineView(getContext());
        mTimeLineView.setDateFormat("HH:mm");
        int count = 120;
        mTimeLineView.setCount(count, count, count);
        initData();
        return mTimeLineView;
    }

    protected void initData() {

        final List<HisData> hisData = Util.get1Day(getContext());
        mTimeLineView.setLastClose(hisData.get(0).getClose());//设置最后一点显示
        LogT.w("最后一点位置:"+hisData.get(0).getClose());
        mTimeLineView.initData(hisData);

    }

}
