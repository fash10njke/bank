package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "wallets")
public class Wallets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_wallets;
    private String currency;
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id_users")
    private Users user;

    public Wallets() {
    }

    public Wallets(int id_wallets, String currency, double amount) {
        this.id_wallets = id_wallets;
        this.currency = currency;
        this.amount = amount;
        //user.addWallet(this);
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getIdWallet() {
        return id_wallets;
    }

    public void setIdWallet(int id_wallets) {
        this.id_wallets = id_wallets;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}