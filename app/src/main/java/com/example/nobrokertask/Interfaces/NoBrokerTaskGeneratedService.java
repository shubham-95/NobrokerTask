package com.example.nobrokertask.Interfaces;

import com.example.nobrokertask.Model.Response.NoBrokerPojo;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

public interface NoBrokerTaskGeneratedService {

    @GET("api/v1/property/filter/region/ChIJLfyY2E4UrjsRVq4AjI7zgRY/?lat_lng=12.9279232,77.6271078&rent=0,500000&travelTime=30")
    Observable<NoBrokerPojo> getApiResponse(@Query("pageNo") String pgno, @Query("type") String type,@Query("buildingType") String bt,@Query("furnishing") String frnsh);

}
