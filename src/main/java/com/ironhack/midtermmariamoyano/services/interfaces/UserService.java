package com.ironhack.midtermmariamoyano.services.interfaces;

import com.ironhack.midtermmariamoyano.models.AccountHolder;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface UserService {
    AccountHolder createAccountHolder(AccountHolder accountHolder);
    void deleteAccountHolder(Long id);
}
