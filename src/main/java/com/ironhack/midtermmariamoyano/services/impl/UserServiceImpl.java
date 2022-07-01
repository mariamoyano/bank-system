package com.ironhack.midtermmariamoyano.services.impl;

import com.ironhack.midtermmariamoyano.models.AccountHolder;
import com.ironhack.midtermmariamoyano.models.User;
import com.ironhack.midtermmariamoyano.repository.UserRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        Optional<User> optionalAccountHolder = userRepository.findByUsername(accountHolder.getUsername());
        if (!optionalAccountHolder.isPresent()) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exits :C");
        }

        return (AccountHolder) optionalAccountHolder.get();
    }

    public void deleteAccountHolder(Long id) {
        User course = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        userRepository.delete(course);

    }
}
