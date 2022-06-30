package com.ironhack.midtermmariamoyano.services.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;

public interface StudentCheckingService {
    void updateBalance(Long id, Money balance);
    void transferMoney(String ownerName,long id);
}
