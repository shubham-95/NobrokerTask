package com.example.nobrokertask;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.nobrokertask.Adapter.MainActivityAdapter;
import com.example.nobrokertask.DI.App;
import com.example.nobrokertask.Interfaces.MainActivityMVP;
import com.example.nobrokertask.Model.Response.Datum;
import com.example.nobrokertask.Model.Response.NoBrokerPojo;
import com.example.nobrokertask.View.FilterActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityMVP.MAView,MainActivityAdapter.Reached,View.OnClickListener{

    @Inject
    MainActivityMVP.MAPresenter maPresenter;

    ProgressBar progressBar;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MainActivityAdapter mainActivityAdapter;
    List<Datum> datumList;
    int finalpgno=1;
    private Button filter;
    Intent intent;
    private String type="",bt="",furnsh="";
    CoordinatorLayout coordinatorLayout;
    Snackbar snackbar;
    int totalcout=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App)getApplicationContext()).getComponent().InjectMain(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        maPresenter.setView(this);
        progressBar=(ProgressBar)findViewById(R.id.progress_bar);
        filter=(Button)findViewById(R.id.filter_main_activity);
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.coordinator_layout);
        intent=getIntent();
        if(intent.getExtras()!=null){
            type=intent.getStringExtra("type");
            bt=intent.getStringExtra("buildingType");
            furnsh=intent.getStringExtra("furnishing");
        }
        maPresenter.LoadData();
        recyclerView=(RecyclerView)findViewById(R.id.main_listing_recyclerview);
        datumList=new ArrayList<>();
        linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && filter.getVisibility() == View.VISIBLE) {
                    filter.animate().alpha(0.0f).translationY(filter.getHeight()).setDuration(3000);
                    filter.setVisibility(View.GONE);
                } else if (dy < 0 && filter.getVisibility() != View.VISIBLE) {
                    filter.setVisibility(View.VISIBLE);
                    filter.animate().alpha(1.0f).translationY(0).setDuration(1000);
                }
            }
        };
        recyclerView.addOnScrollListener(onScrollListener);
        filter.setOnClickListener(this);
    }


    @Override
    public String Pgno() {
        return String.valueOf(finalpgno);
    }

    @Override
    public String Type() {
        return type;
    }

    @Override
    public String BT() {
        return bt;
    }

    @Override
    public String Furnshing() {
        return furnsh;
    }

    @Override
    public void DisplayError(String s) {
        snackbar=Snackbar.make(coordinatorLayout,s,Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void ShowData(NoBrokerPojo noBrokerPojo) {
        if(progressBar!=null && progressBar.isShown())
            progressBar.setVisibility(View.GONE);
        if(noBrokerPojo.getStatusCode()==200 && noBrokerPojo.getData().size()!=0){
            this.datumList=noBrokerPojo.getData();
            totalcout=noBrokerPojo.getOtherParams().getTotalCount();
            mainActivityAdapter=new MainActivityAdapter(this,datumList,this,totalcout);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mainActivityAdapter);
        }
        else{
            if(noBrokerPojo.getStatusCode()!=200){
                DisplayError(noBrokerPojo.getMessage());
            }else if(noBrokerPojo.getData().size()==0){
                DisplayError("No Listings please try after some time");
            }
            else{
                DisplayError(noBrokerPojo.getMessage());
            }
        }
    }

    @Override
    public void UpdataUI(Datum datum) {
        if(datum!=null){
            if(!datumList.get(datumList.size()-1).getTitle().equals(datum.getTitle()) && !datumList.get(datumList.size()-1).getLocation().equals(datum.getLocation()))
                datumList.add(datum);
            mainActivityAdapter.notifyDataSetChanged();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        maPresenter.Unsubscribe();
    }


    @Override
    public void GetPosition(int a) {
        finalpgno=finalpgno+1;
        maPresenter.LoadDataTwice();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.filter_main_activity){
            Intent intent=new Intent(this,FilterActivity.class);
            intent.putExtra("bmap",type);
            intent.putExtra("pmap",bt);
            intent.putExtra("fmap",furnsh);
            startActivity(intent);
        }
    }
}
