package com.ironhack.midtermmariamoyano.controllers.interfaces;

import com.ironhack.midtermmariamoyano.classes.Money;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

public interface StudentCheckingControllerInterface {
    void updateStudentBalance(Long id, int balance);

    Money getBalance(Long id);
}
