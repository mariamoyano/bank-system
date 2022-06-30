package com.ironhack.midtermmariamoyano.services.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.models.Savings;
import com.ironhack.midtermmariamoyano.models.StudentChecking;
import com.ironhack.midtermmariamoyano.repository.CheckingRepository;
import com.ironhack.midtermmariamoyano.repository.StudentCheckingRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.StudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Money getBalance(Long id) {
        Optional<StudentChecking> studentChecking = studentCheckingRepository.findById(id);
        return studentChecking.get().getBalance();
    }
}
