package com.ironhack.midtermmariamoyano.services.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.models.Checking;
import com.ironhack.midtermmariamoyano.models.StudentChecking;
import com.ironhack.midtermmariamoyano.repository.CheckingRepository;
import com.ironhack.midtermmariamoyano.repository.StudentCheckingRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class CheckingServiceImpl implements CheckingService {

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Override
    public void updateCheckingBalance(Long id, Money balance) {

    }

    @Override
    public void transferMoney(String ownerName, long id) {

    }
    public void createCheckingAccount(Checking checking){
        Date date_of_birth = checking.getPrimaryOwner().getDate();
        Period years = Period.between(date_of_birth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        int numberOfYears = years.getYears();

        if(numberOfYears<24){
            StudentChecking studentChecking = new StudentChecking(checking.getId(),checking.getBalance(),checking.getPrimaryOwner(),checking.getSecondaryOwner(),checking.getPenaltyFee(), checking.getSecretKey(),checking.getCreationDate(),checking.getStatus());
            studentCheckingRepository.save(studentChecking);
        }else{
            checkingRepository.save(checking);

        }

    }

    public Money getBalance(Long id) {
        Optional<Checking> checking = checkingRepository.findById(id);
        return checking.get().getBalance();
    }


}
