package com.ironhack.midtermmariamoyano.controllers.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.controllers.dto.CheckingDTO;
import com.ironhack.midtermmariamoyano.models.Checking;

public interface CheckingControllerInterface {


   // String modifyBalance(BalanceDTO balanceDTO);
   void updateChecking( long id,  Money balance);

    void storeAccount(CheckingDTO checkingDTO);
    Money getCheckingBalance( Long id);
}
