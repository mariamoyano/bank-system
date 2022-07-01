package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.controllers.interfaces.UserControllerInterface;
import com.ironhack.midtermmariamoyano.models.AccountHolder;
import com.ironhack.midtermmariamoyano.repository.UserRepository;
import com.ironhack.midtermmariamoyano.security.CustomUserDetails;
import com.ironhack.midtermmariamoyano.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserControllerImpl implements UserControllerInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @GetMapping("/hello-user")
    @ResponseStatus(HttpStatus.OK)
    public String helloUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return "Hello " + userDetails.getUser().getUsername ();
    }

    @PostMapping("/accounts-holders")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolder(@RequestBody @Valid AccountHolder accountHolder){
        return userRepository.save(accountHolder);
    }


    @DeleteMapping("/account-holders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountHolder(@PathVariable Long id) {
        userService.deleteAccountHolder(id);
    }
}
