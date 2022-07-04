package com.ironhack.midtermmariamoyano.repository;

import com.ironhack.midtermmariamoyano.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    @Query("SELECT hashed_key FROM Accounts WHERE id = :id")
    String findHashedKeyById(@Param("id") Long id);
}

