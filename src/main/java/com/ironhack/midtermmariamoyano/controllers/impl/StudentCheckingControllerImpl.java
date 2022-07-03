package com.ironhack.midtermmariamoyano.controllers.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.repository.StudentCheckingRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.StudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentCheckingControllerImpl {

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private StudentCheckingService studentCheckingService;




    //PATCH????????????
    @PutMapping("/student-checking/{balance}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody @Valid Money balance) {
        studentCheckingService.updateBalance(id, balance);
    }


    @GetMapping("/student-balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalance(@PathVariable(name = "id") Long id) {
        return studentCheckingService.getBalance(id);

    }




}
