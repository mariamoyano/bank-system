package com.ironhack.midtermmariamoyano.services.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;

import java.math.BigDecimal;

public interface CheckingService {
    void updateBalance(Long id, Money balance);
    void transferMoney(String ownerName,long id);

}
