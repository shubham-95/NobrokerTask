package com.example.nobrokertask.DI;

import com.example.nobrokertask.Interfaces.MainActivityMVP;
import com.example.nobrokertask.Interfaces.NoBrokerTaskGeneratedService;
import com.example.nobrokertask.Model.MainActivityModel;
import com.example.nobrokertask.Presenter.MainActivityPresenter;
import com.example.nobrokertask.RepoImpl.ImplMainActivityRepo;
import com.example.nobrokertask.Repositories.MainActivityRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NBTaskGeneratedModule.class})
public class MainActivityModule {

    @Provides
    @Singleton
    MainActivityMVP.MAPresenter providesmaPresenter(MainActivityMVP.MAModel maModel){
        return new MainActivityPresenter(maModel);
    }
    @Provides
    @Singleton
    MainActivityMVP.MAModel providesmaMaModel(MainActivityRepo mainActivityRepo){
        return new MainActivityModel(mainActivityRepo);
    }
    @Provides
    @Singleton
    MainActivityRepo mainActivityRepo(NoBrokerTaskGeneratedService noBrokerTaskGeneratedService){
        return new ImplMainActivityRepo(noBrokerTaskGeneratedService);
    }
}
