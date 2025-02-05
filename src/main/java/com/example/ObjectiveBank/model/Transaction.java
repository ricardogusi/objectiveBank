package com.example.ObjectiveBank.model;

public class Transaction {

    private String paymentMethod;
    private Integer accountNumber;
    private Float value;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Float getValue() {
        return value;
    }
}
