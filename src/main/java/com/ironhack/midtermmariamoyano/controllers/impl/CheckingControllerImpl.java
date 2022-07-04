package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.controllers.dto.CheckingDTO;
import com.ironhack.midtermmariamoyano.controllers.interfaces.CheckingControllerInterface;
import com.ironhack.midtermmariamoyano.repository.CheckingRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CheckingControllerImpl implements CheckingControllerInterface {

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private CheckingService checkingService;

    @PatchMapping("/checking/{id}/balance")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateChecking(@PathVariable Long id, @RequestBody @Valid int balance) {
        checkingService.updateCheckingBalance(id, balance);
    }

    //Create a new Checking account
    @PostMapping("/checkings")
    @ResponseStatus(HttpStatus.CREATED)
    public void storeAccount(@RequestBody @Valid CheckingDTO checkingDTO) {

        checkingService.createCheckingAccount(checkingDTO);

    }

    //get balance
    @GetMapping("/checking-balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getCheckingBalance(@PathVariable(name = "id") Long id) {
        return checkingService.getBalance(id);

    }

}
