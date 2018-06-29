package com.example.nobrokertask.DI;

import android.content.Context;

import com.example.nobrokertask.Interfaces.NoBrokerTaskGeneratedService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NBTaskGeneratedModule {

    static{
        System.loadLibrary("native-lib");
    }

    private  static  final  int  CONNECT_TIMEOUT  =  40 ;
    private  static  final  int  WRITE_TIMEOUT  =  40 ;
    private  static  final  int  READ_TIMEOUT  =  40 ;

    @Provides
    @Singleton
    Cache provideOkHttpCache (Context context ) {
        final  int cacheSize =  10  *  1024  *  1024 ;
        return  new  Cache ( context.getCacheDir (), cacheSize);
    }
    @Provides
    @Singleton
    public NoBrokerTaskGeneratedService providesNoBrokerTaskGeneratedService(Cache  cache){
        OkHttpClient.Builder httpclient=new OkHttpClient.Builder();
        httpclient.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpclient.readTimeout(READ_TIMEOUT,TimeUnit.SECONDS);
        httpclient.writeTimeout(WRITE_TIMEOUT,TimeUnit.SECONDS);
        httpclient.cache(cache);
        return new Retrofit.Builder()
                .baseUrl(GetModule(1))
                .client(httpclient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build().create(NoBrokerTaskGeneratedService.class);
    }
    private native String GetModule(int a);

}
