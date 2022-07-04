package com.ironhack.midtermmariamoyano.controller.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermmariamoyano.classes.Address;
import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.models.*;
import com.ironhack.midtermmariamoyano.repository.CreditCardRepository;
import com.ironhack.midtermmariamoyano.repository.ThirdPartyRepository;
import com.ironhack.midtermmariamoyano.repository.UserRepository;
import com.ironhack.midtermmariamoyano.services.interfaces.ThirdPartyService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc // new annotation
public class ThirdPartyControllerImplTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ThirdPartyRepository thirdPartyRepository;
    @Autowired
    private ThirdPartyService thirdPartyService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private User accountHolder, admin;
    private Role adminRole, holderRole;

    private final ObjectMapper objectMapper = new ObjectMapper(); // Hacer bodies
    AccountHolder accountHolder1,accountHolder2;
    ThirdParty thirdParty;

    public ThirdPartyControllerImplTest() {
    }

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
        thirdParty = new ThirdParty("Thirdparty","654321");
        thirdPartyRepository.saveAll(List.of(thirdParty));
    }
    @AfterEach
    void tearDown() {

        userRepository.deleteAll();
        thirdPartyRepository.deleteAll();
    }

    @Test
    void thirdPartyStore_Test_OK() throws Exception{
        ThirdParty thirdParty1 = new ThirdParty("Thirdparty1","654321");
        String body = objectMapper.writeValueAsString(thirdParty);
        MvcResult mvcResult = mockMvc.perform(post("/third-party")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();


    }








}
