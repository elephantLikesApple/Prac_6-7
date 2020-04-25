package com.example.ex1;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TabHost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연습문제 6-7");

        ActionBar ab = getSupportActionBar() ;

        ab.setIcon(R.drawable.app_icon) ;
        ab.setDisplayUseLogoEnabled(true) ;
        ab.setDisplayShowHomeEnabled(true) ;

        ImageView dogtab = new ImageView(this);
        dogtab.setImageResource(R.drawable.selector1);
        ImageView cattab = new ImageView(this);
        cattab.setImageResource(R.drawable.selector2);
        ImageView rabbittab = new ImageView(this);
        rabbittab.setImageResource(R.drawable.selector3);
        ImageView horsetab = new ImageView(this);
        horsetab.setImageResource(R.drawable.selector4);

        tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        tabHost.getTabWidget().setStripEnabled(true);

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tabDog");
        tabSpec.setIndicator(dogtab);
        tabSpec.setContent(R.id.tabDog);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tabCat");
        tabSpec.setIndicator(cattab);
        tabSpec.setContent(R.id.tabCat);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tabRabbit");
        tabSpec.setIndicator(rabbittab);
        tabSpec.setContent(R.id.tabRabbit);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tabHorse");
        tabSpec.setIndicator(horsetab);
        tabSpec.setContent(R.id.tabHorse);
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenHeight = metrics.heightPixels;

        tabHost.getTabWidget().getChildAt(0).getLayoutParams().height = (screenHeight*15)/200+28;
        tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = (screenHeight*15)/200+28;
        tabHost.getTabWidget().getChildAt(2).getLayoutParams().height = (screenHeight*15)/200+28;
        tabHost.getTabWidget().getChildAt(3).getLayoutParams().height = (screenHeight*15)/200+28;
    }

}