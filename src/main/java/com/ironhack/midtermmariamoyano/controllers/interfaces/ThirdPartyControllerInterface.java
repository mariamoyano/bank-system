package com.ironhack.midtermmariamoyano.controllers.interfaces;

import com.ironhack.midtermmariamoyano.controllers.dto.ThirdPartyDTO;
import com.ironhack.midtermmariamoyano.models.ThirdParty;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface ThirdPartyControllerInterface {
    ThirdParty store(@RequestBody @Valid ThirdPartyDTO thirdPartyDTO);
}
