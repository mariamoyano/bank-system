package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.controllers.dto.ThirdPartyDTO;
import com.ironhack.midtermmariamoyano.controllers.interfaces.ThirdPartyControllerInterface;
import com.ironhack.midtermmariamoyano.models.ThirdParty;
import com.ironhack.midtermmariamoyano.repository.ThirdPartyRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class ThirdPartyControllerImpl implements ThirdPartyControllerInterface {
    @Autowired
    private ThirdPartyRepository thirdPartyRepository;
    @Autowired
    private ThirdPartyService thirdPartyService;

    @PostMapping("/third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty store(@RequestBody @Valid ThirdPartyDTO thirdPartyDTO) {
        ThirdParty thirdParty =  store(thirdPartyDTO);
        return thirdPartyRepository.save(thirdParty);
    }
}
