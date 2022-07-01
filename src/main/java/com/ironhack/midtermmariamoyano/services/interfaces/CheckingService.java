package com.ironhack.midtermmariamoyano.services.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.controllers.dto.CheckingDTO;
import com.ironhack.midtermmariamoyano.models.Account;
import com.ironhack.midtermmariamoyano.models.Checking;

import java.math.BigDecimal;

public interface CheckingService {
    void updateCheckingBalance(Long id, Money balance);
    void transferMoney(String ownerName,long id);
    void createCheckingAccount(CheckingDTO checkingDTO);

    Money getBalance(Long id);

}
