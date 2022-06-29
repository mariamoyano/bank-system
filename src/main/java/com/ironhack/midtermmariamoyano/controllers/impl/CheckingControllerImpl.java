package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.controllers.interfaces.CheckingControllerInterface;
import com.ironhack.midtermmariamoyano.security.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CheckingControllerImpl implements CheckingControllerInterface {

    @GetMapping("/checking-user")
    @ResponseStatus(HttpStatus.OK)
    public String checkingUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return userDetails.getUser().getUsername();

    }


}
