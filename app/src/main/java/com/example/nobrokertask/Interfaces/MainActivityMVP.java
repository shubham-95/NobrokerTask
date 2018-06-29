package com.example.nobrokertask.Interfaces;

import com.example.nobrokertask.Model.Response.Datum;
import com.example.nobrokertask.Model.Response.NoBrokerPojo;

import rx.Observable;

public interface MainActivityMVP {
    interface MAView{
        String Pgno();
        String Type();
        String BT();
        String Furnshing();
        void DisplayError(String s);
        void ShowData(NoBrokerPojo noBrokerPojo);
        void UpdataUI(Datum datum);
    }
    interface MAPresenter{
        void setView(MainActivityMVP.MAView view);
        void LoadData();
        void Unsubscribe();
        void LoadDataTwice();
    }
    interface MAModel{
        Observable<NoBrokerPojo> getModelRespo(String pgno, String type, String bt, String furnsh);
        Observable<Datum> getModelRespo1(String pgno, String type, String bt, String furnsh);
    }
}
