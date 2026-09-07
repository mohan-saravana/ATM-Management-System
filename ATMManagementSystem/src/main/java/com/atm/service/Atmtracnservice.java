package com.atm.service;

import java.util.List;

import com.atm.model.Atmtransaction;

public interface Atmtracnservice {

    boolean addTransaction(Atmtransaction transaction);

    List<Atmtransaction> getTransactions(int accountId);
}