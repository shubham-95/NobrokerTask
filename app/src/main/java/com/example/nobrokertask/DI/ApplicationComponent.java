package com.example.nobrokertask.DI;

import com.example.nobrokertask.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class,MainActivityModule.class})
public interface ApplicationComponent {
    void InjectMain(MainActivity mainActivity);
}
