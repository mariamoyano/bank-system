package com.ironhack.midtermmariamoyano.repository;
import com.ironhack.midtermmariamoyano.models.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long>  {
}
