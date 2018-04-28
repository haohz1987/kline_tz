package com.guoziwei.kline;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guoziwei.klinelib.chart.KLineView;
import com.guoziwei.klinelib.model.HisData;

import java.util.List;


public class KLineChartFragment extends Fragment {


    private KLineView mKLineView;
    private int mDay;

    public KLineChartFragment() {
        // Required empty public constructor
    }

    public static KLineChartFragment newInstance(int day) {
        KLineChartFragment fragment = new KLineChartFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("day", day);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDay = getArguments().getInt("day");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kline_chart, container, false);
        mKLineView = v.findViewById(R.id.kline);
        // TODO: 2018/4/28 选择技术指标 
//        RadioGroup rgIndex = v.findViewById(R.id.rg_index);
//        mKLineView.setDateFormat("yyyy-MM-dd");
//        rgIndex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (checkedId == R.id.cb_vol) {
//                    showVolume();
//                } else if (checkedId == R.id.cb_macd) {
//                    showMacd();
//                } else if (checkedId == R.id.cb_kdj) {
//                    showKdj();
//                }
//            }
//        });
        showVolume();
        initData();
//        ((RadioButton) rgIndex.getChildAt(0)).setChecked(true);
        return v;
    }

    public void showVolume() {

        mKLineView.post(new Runnable() {
            @Override
            public void run() {
                mKLineView.showVolume();
            }
        });
    }



    protected void initData() {
        final List<HisData> hisData = Util.getK(getContext(), mDay);
        mKLineView.initData(hisData);
        mKLineView.setLimitLine();

    }

}
