package com.dhrpsr.billingModuleJava.model;

public class Booking {

    private String LR;
    private String customer;
    private String service;
    private String date;
    private String mode;
    private double amount;

    public String getLR() {
        return LR;
    }
    public void setLR(String LR) {
        this.LR = LR;
    }

    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}