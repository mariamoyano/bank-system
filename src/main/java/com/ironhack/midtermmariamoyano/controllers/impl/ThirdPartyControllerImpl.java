package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.controllers.dto.ThirdPartyDTO;
import com.ironhack.midtermmariamoyano.controllers.interfaces.ThirdPartyControllerInterface;
import com.ironhack.midtermmariamoyano.models.ThirdParty;
import com.ironhack.midtermmariamoyano.repository.ThirdPartyRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
public class ThirdPartyControllerImpl implements ThirdPartyControllerInterface {
    @Autowired
    private ThirdPartyRepository thirdPartyRepository;
    @Autowired
    private ThirdPartyService thirdPartyService;

    @PostMapping("/third-parties")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty store(@RequestBody @Valid ThirdPartyDTO thirdPartyDTO) {
        ThirdParty thirdParty =  store(thirdPartyDTO);
        return thirdPartyRepository.save(thirdParty);
    }

//    @PatchMapping("/third-party/{hashedKey}/transfer")
//    @ResponseStatus(HttpStatus.OK)
//    public void transfer(@RequestParam String hashedKey, @RequestBody @Valid  ThirdPartyDTO thirdPartyDTO){
//        thirdPartyService.transfer(hashedKey, thirdPartyDTO);
//    }
}
