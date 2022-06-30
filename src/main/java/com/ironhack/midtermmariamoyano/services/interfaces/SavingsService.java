package com.ironhack.midtermmariamoyano.services.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.models.Savings;

public interface SavingsService {
    void updateBalance(Long id, Money balance);
    void transferMoney(String ownerName,long id);

    Money getBalance(Long id);
}
