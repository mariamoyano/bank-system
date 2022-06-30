package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.models.ThirdParty;
import com.ironhack.midtermmariamoyano.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class ThirdPartyControllerImpl {
    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @PostMapping("/third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty store(@RequestBody @Valid ThirdParty thirdParty) {

        return thirdPartyRepository.save(thirdParty);
    }
}
