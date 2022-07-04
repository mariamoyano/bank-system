package com.ironhack.midtermmariamoyano.services.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;

public interface StudentCheckingService {
    void updateStudentBalance(Long id, int balance);
    void transferMoney(String ownerName,long id);

    Money getBalance(Long id);
}
