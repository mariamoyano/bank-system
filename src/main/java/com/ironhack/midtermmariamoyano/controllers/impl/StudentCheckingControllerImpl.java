package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.controllers.interfaces.StudentCheckingControllerInterface;
import com.ironhack.midtermmariamoyano.repository.StudentCheckingRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.StudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentCheckingControllerImpl implements StudentCheckingControllerInterface {

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private StudentCheckingService studentCheckingService;



    @PatchMapping("/student-checking/{id}/balance")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudentBalance(@PathVariable Long id, @RequestBody @Valid int balance) {
        studentCheckingService.updateStudentBalance(id, balance);
    }


    @GetMapping("/student-balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalance(@PathVariable(name = "id") Long id) {
        return studentCheckingService.getBalance(id);

    }




}
