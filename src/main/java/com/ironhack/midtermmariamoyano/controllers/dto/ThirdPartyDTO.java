package com.ironhack.midtermmariamoyano.controllers.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ThirdPartyDTO {
    @NotNull
    private Long id;
    private String name;
    @NotNull
    private String hashedKey;
    @NotNull
    private BigDecimal balanceTransfer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public BigDecimal getBalanceTranfer() {
        return balanceTransfer;
    }

    public void setBalanceTransfer(BigDecimal balanceTransfer) {
        this.balanceTransfer = balanceTransfer;
    }
}
