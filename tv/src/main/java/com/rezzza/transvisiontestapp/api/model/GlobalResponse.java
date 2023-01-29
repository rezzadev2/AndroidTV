package com.rezzza.transvisiontestapp.api.model;

import java.io.Serializable;
import java.util.ArrayList;

public class GlobalResponse implements Serializable {

    private boolean status;
    private String statusCode;
    private String option;
    private ArrayList<String> message;
    private ArrayList<Object> result;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }

    public void setResult(ArrayList<Object> result) {
        this.result = result;
    }

    public ArrayList<Object> getResult() {
        return result;
    }
}
