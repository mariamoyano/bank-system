package com.ironhack.midtermmariamoyano.controllers.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;
import org.springframework.web.bind.annotation.PathVariable;

public interface CreditCardControllerInterface {
    void updateCreditCardBalance(Long id,  int balance);
    Money getCreditCardBalance(Long id);
}
