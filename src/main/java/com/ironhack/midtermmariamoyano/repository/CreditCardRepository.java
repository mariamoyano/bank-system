package com.ironhack.midtermmariamoyano.repository;

import com.ironhack.midtermmariamoyano.models.CreditCard;
import com.ironhack.midtermmariamoyano.models.StudentChecking;
import com.ironhack.midtermmariamoyano.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    Optional<CreditCard> findById(Long id);
}
