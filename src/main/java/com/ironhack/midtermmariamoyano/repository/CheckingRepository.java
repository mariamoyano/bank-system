package com.ironhack.midtermmariamoyano.repository;
import com.ironhack.midtermmariamoyano.models.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {
}
