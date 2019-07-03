package com.bank.methods;

import com.bank.entity.ExchangeRates;
import com.bank.entity.Transactions;
import com.bank.entity.Users;
import com.bank.entity.Wallets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Methods {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
    private EntityManager em = emf.createEntityManager();
    private ExchangeRates exchangeRates;

    public void initUsers(Users user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void initWallets(Wallets wallet) {
        try {
            em.getTransaction().begin();
            em.merge(wallet);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public void initExchangeRates(ExchangeRates exchangeRate) {
        try {
            em.getTransaction().begin();
            em.merge(exchangeRate);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        }

    }

    public void addTransaction(Transactions transaction) {
        try {
            em.getTransaction().begin();
            em.merge(transaction);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            ex.printStackTrace();
        }
    }

    public void addCash(Transactions transaction, Wallets wallet) {
        wallet.setAmount(wallet.getAmount() + transaction.getAmountCurrency());
        initWallets(wallet);
    }

    public void getCash(Transactions transaction, Wallets wallet) {
        wallet.setAmount(wallet.getAmount() - transaction.getAmountCurrency());
        initWallets(wallet);
    }
    public Double getCashFromAllWallets(Users user) {
        double allCash = 0;
        for (Wallets w: user.getWallets()) {
            if (w.getCurrency().equals("UAH")){
            allCash+=w.getAmount();            }
            else if (w.getCurrency().equals("USD")){
               ExchangeRates a =  em.find(ExchangeRates.class, 1);
               allCash+=(w.getAmount()*a.getValue());}
            else if (w.getCurrency().equals("EUR")){
                ExchangeRates b =  em.find(ExchangeRates.class, 2);
                allCash+=(w.getAmount()*b.getValue());}
        }
        return allCash;
    }


    public void currencyConversion(Transactions transaction, Wallets wallet1, Wallets wallet2, ExchangeRates exchangeRate) {
        wallet1.setAmount(wallet1.getAmount() - transaction.getAmountCurrency());
        wallet2.setAmount(wallet2.getAmount() + (transaction.getAmountCurrency() * exchangeRate.getValue()));
        initWallets(wallet1);
        initWallets(wallet2);
    }

}


