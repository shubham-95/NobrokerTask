package com.example.nobrokertask.DI;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application application;
    public ApplicationModule(Application application){
        this.application=application;
    }
    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }

    @Provides
    @Singleton
    Context providesContext(){
        return application;
    }
}
