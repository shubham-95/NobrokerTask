
package com.example.nobrokertask.Model.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ACCURATELOCATION {

    @SerializedName("display_value")
    @Expose
    private String displayValue;
    @SerializedName("value")
    @Expose
    private String value;

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
