package com.bank.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_users;

    private String fname;
    private String lname;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Wallets> wallets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transactions> transaction;
    public Users() {
    }

    public Users(int id_users, String fname, String lname) {
        this.id_users = id_users;
        this.fname = fname;
        this.lname = lname;
        wallets = new ArrayList<Wallets>();
        transaction = new ArrayList<Transactions>();
    }

    public List<Wallets> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallets> wallets) {
        this.wallets = wallets;
    }

    public List<Transactions> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transactions> transaction) {
        this.transaction = transaction;
    }

    public void addWallet(Wallets wallet){
        wallet.setUser(this);
        this.wallets.add(wallet);
    }

    public void noteTransaction(Transactions transaction){
        transaction.setUser(this);
        this.transaction.add(transaction);
    }
    public int getId_users() {
        return id_users;
    }

    public void setId_users (int id_users) {
        this.id_users = id_users;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
