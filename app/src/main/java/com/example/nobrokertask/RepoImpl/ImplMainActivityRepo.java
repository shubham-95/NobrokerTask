package com.example.nobrokertask.RepoImpl;

import android.util.Log;

import com.example.nobrokertask.Interfaces.NoBrokerTaskGeneratedService;
import com.example.nobrokertask.Model.Response.Datum;
import com.example.nobrokertask.Model.Response.NoBrokerPojo;
import com.example.nobrokertask.Repositories.MainActivityRepo;

import rx.Observable;
import rx.functions.Func1;

public class ImplMainActivityRepo implements MainActivityRepo {
    private NoBrokerTaskGeneratedService noBrokerTaskGeneratedService;

    public ImplMainActivityRepo(NoBrokerTaskGeneratedService noBrokerTaskGeneratedService) {
        this.noBrokerTaskGeneratedService = noBrokerTaskGeneratedService;
    }

    @Override
    public Observable<NoBrokerPojo> getApiRepo(String pgno, String type, String bt, String furnsh) {
        return noBrokerTaskGeneratedService.getApiResponse(pgno,type,bt,furnsh);
    }

    @Override
    public Observable<Datum> getApiRepo1(String pgno, String type, String bt, String furnsh) {
        return noBrokerTaskGeneratedService.getApiResponse(pgno,type,bt,furnsh).flatMap(new Func1<NoBrokerPojo, Observable<Datum>>() {
            @Override
            public Observable<Datum> call(NoBrokerPojo noBrokerPojo) {
                if(noBrokerPojo.getData().size()!=0){
                    return Observable.from(noBrokerPojo.getData());
                }
                else{
                    Datum dd=new Datum();
                    dd.setTitle("LE");
                    return Observable.just(dd);
                }
            }
        });
    }
}
