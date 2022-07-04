package com.ironhack.midtermmariamoyano.controllers.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface SavingsControllerInterface {
    void updateSavingsBalance(Long id,  int balance);
    Money getBalance(Long id);
}
