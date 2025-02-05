package com.example.ObjectiveBank.model;

public class Transaction {

    private String formaDePagamento;
    private Integer numeroDaCotna;
    private Float saldo;

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Integer getNumeroDaCotna() {
        return numeroDaCotna;
    }

    public void setNumeroDaCotna(Integer numeroDaCotna) {
        this.numeroDaCotna = numeroDaCotna;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
}
