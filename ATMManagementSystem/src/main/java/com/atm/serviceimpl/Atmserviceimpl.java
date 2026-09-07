package com.atm.serviceimpl;

import com.atm.dao.Atmdao;
import com.atm.daoimpl.Atmuserdaoimpl;
import com.atm.model.Atmuser;
import com.atm.service.AtmService;

public class Atmserviceimpl implements AtmService {

    private Atmdao userDAO =
            new Atmuserdaoimpl();

    @Override
    public Atmuser login(String username, String pin) {

        return userDAO.login(username, pin);
    }

    @Override
    public boolean changePin(int userId, String newPin) {

        return userDAO.changePin(userId, newPin);
    }
}