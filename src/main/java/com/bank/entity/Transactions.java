package com.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transactions;
    private int fromWallet;
    private int toWallet;
    private double amountCurrency;
    String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id_users")
    private Users user;

    public Transactions() {
    }

    public Transactions(int id_transaction, int fromWallet, int toWallet, double amountCurrency, String comment) {
        this.id_transactions = id_transactions;
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.amountCurrency = amountCurrency;
        this.comment = comment;

    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getId_transactions() {
        return id_transactions;
    }

    public void setId_transactions(int id_transactions) {
        this.id_transactions = id_transactions;
    }

    public double getAmountCurrency() {
        return amountCurrency;
    }

    public void setAmountCurrency(double amountCurrency) {
        this.amountCurrency = amountCurrency;
    }

    public int getFromWallet() {
        return fromWallet;
    }

    public void setFromWallet(int fromWallet) {
        this.fromWallet = fromWallet;
    }

    public int getToWallet() {
        return toWallet;
    }

    public void setToWallet(int toWallet) {
        this.toWallet = toWallet;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
