package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.controllers.dto.ThirdPartyDTO;
import com.ironhack.midtermmariamoyano.controllers.interfaces.AccountsControllerInterface;

import com.ironhack.midtermmariamoyano.services.interfaces.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AccountsControllerImpl implements AccountsControllerInterface {

    @Autowired
    private AccountsService accountsService;
//
//    @PatchMapping("/third-party/{hashedKey}/transfer")
//    @ResponseStatus(HttpStatus.OK)
//    public void transfer(@RequestParam String hashedKey, @RequestBody @Valid ThirdPartyDTO thirdPartyDTO){
//        accountsService.transfer(hashedKey, thirdPartyDTO);
//    }
}
