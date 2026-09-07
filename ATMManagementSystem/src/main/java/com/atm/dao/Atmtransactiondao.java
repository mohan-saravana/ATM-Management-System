package com.atm.dao;

import java.util.List;

import com.atm.model.Atmtransaction;

public interface Atmtransactiondao{

    boolean addTransaction(Atmtransaction transaction);

    List<Atmtransaction> getTransactions(int accountId);
}