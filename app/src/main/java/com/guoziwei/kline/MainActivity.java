package com.guoziwei.kline;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tab);
        final ViewPager viewPager = findViewById(R.id.view_pager);
        //定义不同的分割时间,传入分隔单位 FiveDayChartFragment.newInstance(),
        Fragment[] fragments = {TimeLineChartFragment.newInstance(1),
                KLineChartFragment.newInstance(1), KLineChartFragment.newInstance(7),
                KLineChartFragment.newInstance(30), KLineChartFragment.newInstance(90), KLineChartFragment.newInstance(365),};
        String[] titles = {"分时图","日K", "周K", "月","季度","年"};
        viewPager.setOffscreenPageLimit(fragments.length);//预加载页数
        viewPager.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles));
        //TabLayout+ViewPage建立关联
        tabLayout.setupWithViewPager(viewPager);
        //模拟横竖屏切换
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullScreenChartActivity.launch(MainActivity.this, viewPager.getCurrentItem());
            }
        });
    }
}
