package com.bank.main;

import com.bank.entity.ExchangeRates;
import com.bank.entity.Transactions;
import com.bank.entity.Users;
import com.bank.entity.Wallets;
import com.bank.methods.Methods;

public class App {
    public static void main(String[] args) {
        Methods methods = new Methods();
        //добавляем пользователей
        Users user1 = new Users(1, "ivan", "ivanov");
        Users user2 = new Users(2, "petr", "petrov");
        Users user3 = new Users(3, "anton", "antonov");

        methods.initUsers(user1);
        methods.initUsers(user2);
        methods.initUsers(user3);

        //добавляем счета
        Wallets wallets1 = new Wallets(1, "UAH", 100.0);
        Wallets wallets2 = new Wallets(2, "USD", 50.0);
        Wallets wallets3 = new Wallets(3, "EUR", 80.0);
        Wallets wallets4 = new Wallets(4, "UAH", 150.0);

        //присваиваем пользователям счета
        user1.addWallet(wallets1);
        user2.addWallet(wallets2);
        user3.addWallet(wallets3);
        user3.addWallet(wallets4);

        methods.initWallets(wallets1);
        methods.initWallets(wallets2);
        methods.initWallets(wallets3);
        methods.initWallets(wallets4);

        //произовдим транзакции
        //пополняем счет в нужной валюте
        Transactions transactions = new Transactions(1, 1, 1, 60, "Зачисление средств");
        user1.noteTransaction(transactions);
        methods.addTransaction(transactions);
        methods.addCash(transactions, wallets1);
        //перевод средств с одного счета на другой

        //конвертации валюты по курсу в рамках счетов одного пользователя
        ExchangeRates exchangeRates1 = new ExchangeRates(1, 26.3, "USD");
        ExchangeRates exchangeRates2 = new ExchangeRates(2, 29.8, "EUR");
        methods.initExchangeRates(exchangeRates1);
        methods.initExchangeRates(exchangeRates2);
        Transactions transactions3 = new Transactions(1, 3, 4, 20, "Конвертация валюты со счета EUR на счет UAH");
        user3.noteTransaction(transactions3);
        methods.addTransaction(transactions3);
        methods.getCash(transactions3, wallets3);
        methods.addCash(transactions3, wallets4);
        methods.currencyConversion(transactions3, wallets3, wallets4, exchangeRates2);
        //запрос для получения суммарных средств на счету одного пользователя в UAH ( расчет по курсу)
        System.out.println("Суммарное количетсво средств на счетах: " + methods.getCashFromAllWallets(user3) + " грн.");
    }
}
