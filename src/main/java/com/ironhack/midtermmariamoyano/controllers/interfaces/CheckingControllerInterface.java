package com.ironhack.midtermmariamoyano.controllers.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.controllers.dto.BalanceDTO;
import com.ironhack.midtermmariamoyano.models.Checking;
import com.ironhack.midtermmariamoyano.security.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface CheckingControllerInterface {


   // String modifyBalance(BalanceDTO balanceDTO);
   void updateChecking( long id,  Money balance);

    void storeAccount(Checking checking);
    Money getCheckingBalance( Long id);
}
