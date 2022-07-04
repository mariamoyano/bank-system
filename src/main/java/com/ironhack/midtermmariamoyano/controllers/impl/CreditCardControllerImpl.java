package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.repository.CreditCardRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CreditCardControllerImpl {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardService creditCardService;

///Cambiar el balance
    @PatchMapping("/credit-card/{id}/balance/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCreditCardBalance(@PathVariable Long id, @RequestBody @Valid  int balance) {
        creditCardService.updateCreditCardBalance(id, balance);
    }


    @GetMapping("/credit-balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getCreditCardBalance(@PathVariable(name = "id") Long id) {
        return creditCardService.getBalance(id);

    }
}
