package com.ironhack.midtermmariamoyano.repository;

import com.ironhack.midtermmariamoyano.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findById(Long id);
//    @Query("SELECT hashed_key FROM Accounts WHERE id = :id")
//    String findSecretKeyById(@Param("id") Long id);

}

