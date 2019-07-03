package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "exchange_rates")
public class ExchangeRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_exchange_rates;

    private String currency;
    private double value;

    public ExchangeRates() {
    }

    public ExchangeRates(int id_exchange_rates, double value, String currency) {
        this.id_exchange_rates = id_exchange_rates;
        this.value = value;
        this.currency = currency;
    }

    public int getIdExchangeRates() {
        return id_exchange_rates;
    }

    public void setIdExchangeRates(int idExchangeRates) {
        this.id_exchange_rates = idExchangeRates;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
