package com.atm.service;

import com.atm.model.Atmuser;

public interface AtmService {

    Atmuser login(String username, String pin);

    boolean changePin(int userId, String newPin);
}