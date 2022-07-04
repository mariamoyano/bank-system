package com.ironhack.midtermmariamoyano.services.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.controllers.dto.ThirdPartyDTO;
import com.ironhack.midtermmariamoyano.models.Accounts;
import com.ironhack.midtermmariamoyano.models.ThirdParty;
import com.ironhack.midtermmariamoyano.repository.AccountsRepository;
import com.ironhack.midtermmariamoyano.repository.StudentCheckingRepository;
import com.ironhack.midtermmariamoyano.repository.ThirdPartyRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService{

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;

    @Autowired
    private AccountsRepository accountsRepository;
    public ThirdParty store(ThirdPartyDTO thirdPartyDTO) {
        ThirdParty thirdParty = new ThirdParty(thirdPartyDTO.getName(),thirdPartyDTO.getHashedKey());
        return thirdParty;
    }


    public void transfer(String hashedKey, ThirdPartyDTO thirdPartyDTO) {
        Long targetAccountId = thirdPartyDTO.getId();
        Accounts targetAccount = accountsRepository.findById(targetAccountId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
        String secretKey = accountsRepository.findHashedKeyById(targetAccountId);
        if(secretKey.equals(thirdPartyDTO.getHashedKey())){
            targetAccount.setBalance(new Money(targetAccount.getBalance().getAmount().add(thirdPartyDTO.getBalanceTranfer())));
            accountsRepository.save(targetAccount);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
