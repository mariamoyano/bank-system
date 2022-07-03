package com.ironhack.midtermmariamoyano.services.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.controllers.dto.CheckingDTO;

public interface CheckingService {
    void updateCheckingBalance(Long id, Money balance);
    void transferMoney(String ownerName,long id);
    void createCheckingAccount(CheckingDTO checkingDTO);

    Money getBalance(Long id);

}
