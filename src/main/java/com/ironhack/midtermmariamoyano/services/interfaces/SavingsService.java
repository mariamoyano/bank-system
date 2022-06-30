package com.ironhack.midtermmariamoyano.services.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;

public interface SavingsService {
    void updateBalance(Long id, Money balance);
    void transferMoney(String ownerName,long id);
}
