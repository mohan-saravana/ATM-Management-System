package com.atm.dao;

import com.atm.model.Atmuser;

public interface Atmdao {

    Atmuser login(String username, String pin);

    boolean changePin(int userId, String newPin);
}