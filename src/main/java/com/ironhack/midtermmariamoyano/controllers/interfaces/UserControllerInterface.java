package com.ironhack.midtermmariamoyano.controllers.interfaces;

import com.ironhack.midtermmariamoyano.security.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

public interface UserControllerInterface {
    String hello(@AuthenticationPrincipal CustomUserDetails userDetails);
    void deleteAccountHolder(Long id);
}
