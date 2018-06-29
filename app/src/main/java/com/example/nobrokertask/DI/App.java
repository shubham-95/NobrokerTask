package com.example.nobrokertask.DI;

import android.app.Application;

public class App extends Application{

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent=DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .mainActivityModule(new MainActivityModule())
                .build();

    }
    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

}
