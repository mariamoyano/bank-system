package com.ironhack.midtermmariamoyano.services.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.repository.CheckingRepository;
import com.ironhack.midtermmariamoyano.repository.StudentCheckingRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.StudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCheckingServiceImpl implements StudentCheckingService {

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;


    @Override
    public void updateBalance(Long id, Money balance) {

    }

    @Override
    public void transferMoney(String ownerName, long id) {

    }
}
