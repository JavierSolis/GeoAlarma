package com.pineapplelab.app.geoalarma.ui.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pineapplelab.app.geoalarma.R;
import com.pineapplelab.app.geoalarma.mapper.MapperViewModel;
import com.pineapplelab.app.geoalarma.persistence.dao.DaoAlarm;
import com.pineapplelab.app.geoalarma.persistence.entity.EntityAlarm;
import com.pineapplelab.app.geoalarma.ui.adapter.AdapterAlarm;
import com.pineapplelab.app.geoalarma.ui.viewmodel.ViewModelAlarm;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Javier Solis @JavierTwiteando  @PineappleTic on 29/11/15.
 */
public class ActivityListAlarms
extends
        AppCompatActivity{


    @Bind(R.id.list_alarms)
    public RecyclerView rv;

    private AdapterAlarm adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alarms);
        ButterKnife.bind(this);

        //
        this.daoAlarm = new DaoAlarm();
        initViews();
        //RecyclerView rv = (RecyclerView)findViewById(R.id.list_alarms);

    }

    DaoAlarm daoAlarm;
    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout)findViewById(R.id.ctlLayout);
        ctlLayout.setTitle("Alarmas");



        rv.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        );

        rv.setItemAnimator(new DefaultItemAnimator());


        //data de dao
        List<EntityAlarm> list = this.daoAlarm.getAllAlarms();
        List<ViewModelAlarm> listViewModel = MapperViewModel.Alarm.map(list);

        this.adapter = new AdapterAlarm(this,listViewModel);
        rv.setAdapter(adapter);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            if (hasFocus) {
                getWindow().getDecorView()
                        .setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
    }
}
