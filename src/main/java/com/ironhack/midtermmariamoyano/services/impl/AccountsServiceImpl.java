package com.ironhack.midtermmariamoyano.services.impl;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.controllers.dto.ThirdPartyDTO;
import com.ironhack.midtermmariamoyano.models.Accounts;
import com.ironhack.midtermmariamoyano.repository.AccountsRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountsServiceImpl implements AccountsService {
    @Autowired
    private AccountsRepository accountsRepository;

//    public void transfer(String hashedKey, ThirdPartyDTO thirdPartyDTO) {
//        Long targetAccountId = thirdPartyDTO.getId();
//        Accounts targetAccount =accountsRepository.findById(targetAccountId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
//        String secretKey = accountsRepository.findSecretKeyById(targetAccountId);
//        if(secretKey.equals(thirdPartyDTO.getHashedKey())){
//            targetAccount.setBalance(new Money(targetAccount.getBalance().getAmount().add(thirdPartyDTO.getBalanceTranfer())));
//            accountsRepository.save(targetAccount);
//        } else{
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }
}
