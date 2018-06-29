package com.example.nobrokertask.Repositories;

import com.example.nobrokertask.Model.Response.Datum;
import com.example.nobrokertask.Model.Response.NoBrokerPojo;

import rx.Observable;


public interface MainActivityRepo {
    Observable<NoBrokerPojo> getApiRepo(String pgno,String type,String bt,String furnsh);
    Observable<Datum> getApiRepo1(String pgno,String type,String bt,String furnsh);
}
