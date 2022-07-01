package com.ironhack.midtermmariamoyano.services.impl;

import com.ironhack.midtermmariamoyano.controllers.dto.ThirdPartyDTO;
import com.ironhack.midtermmariamoyano.models.ThirdParty;
import com.ironhack.midtermmariamoyano.services.interfaces.ThirdPartyService;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService{


    public ThirdParty store(ThirdPartyDTO thirdPartyDTO) {
        ThirdParty thirdParty = new ThirdParty(thirdPartyDTO.getName(),thirdPartyDTO.getHashedKey());
        return thirdParty;
    }
}
