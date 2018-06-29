
package com.example.nobrokertask.Model.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Score {

    @SerializedName("lastUpdatedDate")
    @Expose
    private BigInteger lastUpdatedDate;
    @SerializedName("transit")
    @Expose
    private Double transit;
    @SerializedName("lifestyle")
    @Expose
    private Double lifestyle;

    public BigInteger getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(BigInteger lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Double getTransit() {
        return transit;
    }

    public void setTransit(Double transit) {
        this.transit = transit;
    }

    public Double getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Double lifestyle) {
        this.lifestyle = lifestyle;
    }

}
