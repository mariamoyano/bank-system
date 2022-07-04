package com.ironhack.midtermmariamoyano.controller.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermmariamoyano.classes.Address;
import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.models.*;
import com.ironhack.midtermmariamoyano.repository.CreditCardRepository;
import com.ironhack.midtermmariamoyano.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // new annotation
public class CreditCardControllerImplTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    private User accountHolder, admin;
    private Role adminRole, holderRole;

    private final ObjectMapper objectMapper = new ObjectMapper(); // Hacer bodies
    AccountHolder accountHolder1,accountHolder2;
    CreditCard creditCard;
    @BeforeEach
    void setUp() {
        admin = new Admin("admin", passwordEncoder.encode("123456"),"admin1");
        adminRole = new Role("ADMIN", admin);
        admin.setRoles(Set.of(adminRole));
        Address primaryOwner = new Address("Calle nombre1","Madrid",28002);
        Address secondaryOwner = new Address("Avenida nombre2","Madrid",28040);

        accountHolder = new AccountHolder("accountholder", passwordEncoder.encode("123456"),"Holder1", Date.valueOf("1987-03-16"),primaryOwner,secondaryOwner);
        holderRole = new Role("ACCOUNT_HOLDER", accountHolder);
        accountHolder.setRoles(Set.of(holderRole));
        userRepository.saveAll(List.of(accountHolder, admin));
        Address address3=  new Address("Paseo nombre3","Madrid",28021);
        Address address4=  new Address("Plaza nombre4","Madrid",28033);
        accountHolder1 =  new AccountHolder("accountholder", passwordEncoder.encode("123456"),"Holder1", Date.valueOf("1987-03-16"),address3,address4);
        accountHolder2 =  new AccountHolder("accountholder", passwordEncoder.encode("123456"),"Holder2", Date.valueOf("1997-08-9"),primaryOwner,secondaryOwner);
        creditCard =new CreditCard(new Money(new BigDecimal(1000)),"12345",accountHolder1,accountHolder2,new Money(new BigDecimal(40)),new Money(new BigDecimal(250)),BigDecimal.valueOf(0.2),Date.valueOf("2021-05-22"));
    }
    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void getCreditCardBalance_Test() throws Exception {
        String body = objectMapper.writeValueAsString(creditCard);
        MvcResult mvcResult = mockMvc.perform(get("/credit-balance/"+creditCard.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("1000"));
    }
    @Test
    void updateCreditCardBalance_Test() throws Exception {
        String body = objectMapper.writeValueAsString(creditCard);

        MvcResult mvcResult = mockMvc.perform(patch("/credit-card/"+creditCard.getId()+"/balance")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("1000"));
    }


}


