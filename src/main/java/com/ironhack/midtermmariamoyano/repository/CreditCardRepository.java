package com.ironhack.midtermmariamoyano.repository;

import com.ironhack.midtermmariamoyano.models.CreditCard;
import com.ironhack.midtermmariamoyano.models.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
