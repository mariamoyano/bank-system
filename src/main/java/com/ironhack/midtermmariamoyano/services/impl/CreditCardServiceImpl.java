package com.ironhack.midtermmariamoyano.services.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.models.CreditCard;
import com.ironhack.midtermmariamoyano.repository.CreditCardRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;


    public void updateCreditCardBalance(Long id, int balance) {
        Optional <CreditCard> creditCardOptional = creditCardRepository.findById(id);
        creditCardOptional.get().setBalance(new Money(BigDecimal.valueOf(balance)));
    }


    public void transferMoney(String ownerName, long id) {

    }

    public Money getBalance(Long id) {
        Optional<CreditCard> creditCard = creditCardRepository.findById(id);

        return creditCard.get().interestBalance();
    }
}
