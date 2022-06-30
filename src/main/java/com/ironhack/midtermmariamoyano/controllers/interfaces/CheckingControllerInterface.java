package com.ironhack.midtermmariamoyano.controllers.interfaces;

import com.ironhack.midtermmariamoyano.controllers.dto.BalanceDTO;
import com.ironhack.midtermmariamoyano.security.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

public interface CheckingControllerInterface {

    String checkingUser(CustomUserDetails userDetails);
   // String modifyBalance(BalanceDTO balanceDTO);
}
