package com.ironhack.midtermmariamoyano.controllers.interfaces;

import com.ironhack.midtermmariamoyano.controllers.dto.ThirdPartyDTO;
import com.ironhack.midtermmariamoyano.models.ThirdParty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public interface ThirdPartyControllerInterface {
    ThirdParty store(ThirdPartyDTO thirdPartyDTO);

}
