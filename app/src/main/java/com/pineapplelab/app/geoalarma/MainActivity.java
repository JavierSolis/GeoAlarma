package com.pineapplelab.app.geoalarma;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.github.fabtransitionactivity.SheetLayout;

public class MainActivity extends AppCompatActivity
        implements
        SheetLayout.OnFabAnimationEndListener,
        View.OnClickListener{

    public FloatingActionButton btnAdd;
    public ListView listAlarms;


    public SheetLayout mSheetLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initViews();
        this.initEvents();
    }



    private void initViews() {
        this.btnAdd = (FloatingActionButton) findViewById(R.id.fab);
        this.listAlarms = (ListView)findViewById(R.id.list_alarms);
        this.mSheetLayout = (SheetLayout)findViewById(R.id.bottom_sheet);

        mSheetLayout.setFab(this.btnAdd);
        mSheetLayout.setFabAnimationEndListener(this);
    }

    private void initEvents() {
        this.btnAdd.setOnClickListener(this);
    }


    //
    @Override
    public void onFabAnimationEnd() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 12);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.mSheetLayout.contractFab();
    }
    //evento
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.fab)
        {
            this.mSheetLayout.expandFab();
        }
    }
}
