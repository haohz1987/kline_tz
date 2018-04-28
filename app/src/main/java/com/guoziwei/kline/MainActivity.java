package com.guoziwei.kline;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
//    private ArrayAdapter<String> adapter;
//    private static final String[] dataType = {"1分", "5分","15分","30分","60分","120分"};
//    private List<String> spinList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tab);
//        adapter = new ArrayAdapter<String>(this, R.layout.myspinner, dataType);
//        Spinner spinner = findViewById(R.id.spinner);
//        spinner.setAdapter(adapter);
//        int position = adapter.getPosition(dataType[0]);
//        spinner.setSelection(position);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if(position==0){
//                    LogT.w("选择第1项,1分");
//                }else if(position==1){
//                    LogT.w("选择第2项,5分");
//
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });




        final ViewPager viewPager = findViewById(R.id.view_pager);
        //定义不同的分割时间,传入分隔单位 FiveDayChartFragment.newInstance(),
        Fragment[] fragments = {TimeLineChartFragment.newInstance(1),
                KLineChartFragment.newInstance(1), KLineChartFragment.newInstance(7),
                KLineChartFragment.newInstance(30), KLineChartFragment.newInstance(90), KLineChartFragment.newInstance(365),};
        String[] titles = {"分时图","日K", "周K", "月","季度","年"};
        viewPager.setOffscreenPageLimit(fragments.length);//预加载页数
        viewPager.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles));
        viewPager.setCurrentItem(1);
        //TabLayout+ViewPage建立关联
        tabLayout.setupWithViewPager(viewPager);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullScreenChartActivity.launch(MainActivity.this, viewPager.getCurrentItem());
            }
        });
    }
}
