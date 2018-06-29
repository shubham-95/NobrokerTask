package com.example.nobrokertask.Model;

import com.example.nobrokertask.Interfaces.MainActivityMVP;
import com.example.nobrokertask.Model.Response.Datum;
import com.example.nobrokertask.Model.Response.NoBrokerPojo;
import com.example.nobrokertask.Repositories.MainActivityRepo;

import rx.Observable;

public class MainActivityModel implements MainActivityMVP.MAModel {
    private MainActivityRepo mainActivityRepo;

    public MainActivityModel(MainActivityRepo mainActivityRepo) {
        this.mainActivityRepo = mainActivityRepo;
    }

    @Override
    public Observable<NoBrokerPojo> getModelRespo(String pgno, String type, String bt, String furnsh) {
        return mainActivityRepo.getApiRepo(pgno,type,bt,furnsh);
    }

    @Override
    public Observable<Datum> getModelRespo1(String pgno, String type, String bt, String furnsh) {
        return mainActivityRepo.getApiRepo1(pgno,type,bt,furnsh);
    }
}
