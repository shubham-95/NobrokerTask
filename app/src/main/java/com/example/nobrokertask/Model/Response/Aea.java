
package com.example.nobrokertask.Model.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aea {

    @SerializedName("ACCURATE_LOCATION")
    @Expose
    private ACCURATELOCATION aCCURATELOCATION;
    @SerializedName("GATED_SECURITY")
    @Expose
    private GATEDSECURITY gATEDSECURITY;
    @SerializedName("NON_VEG_ALLOWED")
    @Expose
    private NONVEGALLOWED nONVEGALLOWED;
    @SerializedName("HOUSE_KEY_WITH")
    @Expose
    private HOUSEKEYWITH hOUSEKEYWITH;

    public ACCURATELOCATION getACCURATELOCATION() {
        return aCCURATELOCATION;
    }

    public void setACCURATELOCATION(ACCURATELOCATION aCCURATELOCATION) {
        this.aCCURATELOCATION = aCCURATELOCATION;
    }

    public GATEDSECURITY getGATEDSECURITY() {
        return gATEDSECURITY;
    }

    public void setGATEDSECURITY(GATEDSECURITY gATEDSECURITY) {
        this.gATEDSECURITY = gATEDSECURITY;
    }

    public NONVEGALLOWED getNONVEGALLOWED() {
        return nONVEGALLOWED;
    }

    public void setNONVEGALLOWED(NONVEGALLOWED nONVEGALLOWED) {
        this.nONVEGALLOWED = nONVEGALLOWED;
    }

    public HOUSEKEYWITH getHOUSEKEYWITH() {
        return hOUSEKEYWITH;
    }

    public void setHOUSEKEYWITH(HOUSEKEYWITH hOUSEKEYWITH) {
        this.hOUSEKEYWITH = hOUSEKEYWITH;
    }

}
