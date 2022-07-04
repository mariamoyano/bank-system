package com.ironhack.midtermmariamoyano.services.interfaces;

import com.ironhack.midtermmariamoyano.controllers.dto.ThirdPartyDTO;
import com.ironhack.midtermmariamoyano.models.ThirdParty;

public interface ThirdPartyService {
    ThirdParty store(ThirdPartyDTO thirdPartyDTO);

    void transfer(String hashedKey, ThirdPartyDTO thirdPartyDTO);

}
