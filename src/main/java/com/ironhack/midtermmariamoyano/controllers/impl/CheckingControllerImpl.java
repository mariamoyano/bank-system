package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.controllers.interfaces.CheckingControllerInterface;
import com.ironhack.midtermmariamoyano.repository.CheckingRepository;
import com.ironhack.midtermmariamoyano.security.CustomUserDetails;
import com.ironhack.midtermmariamoyano.services.interfaces.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
public class CheckingControllerImpl implements CheckingControllerInterface {

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private CheckingService checkingService;
    @GetMapping("/checking-user")
    @ResponseStatus(HttpStatus.OK)
    public String checkingUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return userDetails.getUser().getUsername();

    }

    @PutMapping("/checking/{balance}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody @Valid Money balance) {
        checkingService.updateBalance(id, balance);
    }

}
