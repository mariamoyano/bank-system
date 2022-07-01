package com.ironhack.midtermmariamoyano.controllers.interfaces;

import com.ironhack.midtermmariamoyano.security.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

public interface UserControllerInterface {
    String helloUser(@AuthenticationPrincipal CustomUserDetails userDetails);
}
