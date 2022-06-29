package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class StudentChecking extends User{

    private String secretKey;
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    public StudentChecking() {

    }




    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
