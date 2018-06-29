package com.example.nobrokertask.Presenter;

import android.util.Log;

import com.example.nobrokertask.Interfaces.MainActivityMVP;
import com.example.nobrokertask.Model.Response.Datum;
import com.example.nobrokertask.Model.Response.NoBrokerPojo;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityPresenter implements MainActivityMVP.MAPresenter{
    private MainActivityMVP.MAView maView;
    private MainActivityMVP.MAModel maModel;
    private Subscription subscription=null;

    public MainActivityPresenter(MainActivityMVP.MAModel maModel) {
        this.maModel = maModel;
    }

    @Override
    public void setView(MainActivityMVP.MAView view) {
        this.maView=view;
    }

    @Override
    public void LoadData() {
        if(maView!=null){
            subscription=maModel.getModelRespo(maView.Pgno(),maView.Type(),maView.BT(),maView.Furnshing()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<NoBrokerPojo>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    if(maView!=null)
                        maView.DisplayError(e.getMessage());
                }

                @Override
                public void onNext(NoBrokerPojo noBrokerPojo) {
                    if(maView!=null)
                        maView.ShowData(noBrokerPojo);
                }
            });
        }
    }

    @Override
    public void Unsubscribe() {
        if(subscription!=null){
            if(!subscription.isUnsubscribed())
                subscription.unsubscribe();
        }
    }

    @Override
    public void LoadDataTwice() {
        if(maView!=null){
            subscription=maModel.getModelRespo1(maView.Pgno(),maView.Type(),maView.BT(),maView.Furnshing()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Datum>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    if(maView!=null)
                        maView.DisplayError(e.getMessage());
                }

                @Override
                public void onNext(Datum datum) {
                    if(maView!=null)
                        maView.UpdataUI(datum);
                }
            });
        }
    }
}
