package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.controllers.interfaces.SavingsControllerInterface;
import com.ironhack.midtermmariamoyano.repository.SavingsRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class SavingsControllerImpl implements SavingsControllerInterface {

    @Autowired
    private SavingsRepository SavingsRepository;

    @Autowired
    private SavingsService savingsService;


    //Obtener el balance y actualizar interesRate
    @GetMapping("/savings-balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalance(@PathVariable(name = "id") Long id) {
        return savingsService.getBalance(id);

    }

    @PatchMapping("/savings/{id}/balance/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSavingsBalance(@PathVariable Long id, @RequestBody @Valid  int balance) {
        savingsService.updateSavingsBalance(id, balance);
    }
}
