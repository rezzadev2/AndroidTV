package com.rezzza.transvisiontestapp.model;

import java.io.Serializable;

public class Coupon implements Serializable {

    private String id;
    private String name;
    private String brandLogo;
    private String couponTnc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getCouponTnc() {
        return couponTnc;
    }

    public void setCouponTnc(String couponTnc) {
        this.couponTnc = couponTnc;
    }
}
