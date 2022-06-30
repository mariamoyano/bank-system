package com.ironhack.midtermmariamoyano.services.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.models.Savings;
import com.ironhack.midtermmariamoyano.repository.CheckingRepository;
import com.ironhack.midtermmariamoyano.repository.SavingsRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class SavingsServiceImpl implements SavingsService {
    @Autowired
    private SavingsRepository savingsRepository;


    @Override
    public void updateBalance(Long id, Money balance) {

    }

    @Override
    public void transferMoney(String ownerName, long id) {

    }



    public Money getBalance(Long id) {
        Optional<Savings> savings = savingsRepository.findById(id);
        savings.get().interestBalance();
        return savings.get().getBalance();
    }


}
