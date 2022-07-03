package com.ironhack.midtermmariamoyano.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.midtermmariamoyano.classes.Address;
import com.ironhack.midtermmariamoyano.models.AccountHolder;
import com.ironhack.midtermmariamoyano.models.Admin;
import com.ironhack.midtermmariamoyano.models.Role;
import com.ironhack.midtermmariamoyano.models.User;
import com.ironhack.midtermmariamoyano.repository.UserRepository;
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

import java.sql.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
    @AutoConfigureMockMvc // new annotation
    public class UserControllerImplTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        private User accountHolder, admin;
        private Role adminRole, holderRole;

        private final ObjectMapper objectMapper = new ObjectMapper(); // Hacer bodies

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

     //mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        }

        @AfterEach
        void tearDown() {
            userRepository.deleteAll();
        }

    @Test
    void hello() throws Exception {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", "Basic YWRtaW46MTIzNDU2");
            httpHeaders.add("Authorization", "Basic dGVjaG5pY2lhbjoxMjM0NTY=");
            MvcResult mvcResult = mockMvc.perform(get("/hello").headers(httpHeaders))
                    .andExpect(status().isOk())
                    .andReturn();

            assertTrue(mvcResult.getResponse().getContentAsString().contains("WELCOME !!!"));
        }

    @Test
    void helloUser() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic YWRtaW46MTIzNDU2");
        httpHeaders.add("Authorization", "Basic dGVjaG5pY2lhbjoxMjM0NTY=");
        MvcResult mvcResult = mockMvc.perform(get("/hello-user").headers(httpHeaders))
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Hello " + admin.getUsername()));

    }


    @Test
    void createAccountHolder_test_OK() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic YWRtaW46MTIzNDU2");
        Address address3=  new Address("Paseo nombre3","Madrid",28021);
        Address address4=  new Address("Plaza nombre4","Madrid",28033);
        AccountHolder accountHolder1 =  new AccountHolder("accountholder", passwordEncoder.encode("123456"),"Holder1", Date.valueOf("1987-03-16"),address3,address4);
        String body = objectMapper.writeValueAsString(accountHolder1);
        MvcResult mvcResult = mockMvc.perform(
                           post("/accounts-holders")
                                    .content(body)
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .headers(httpHeaders)
                    )
                    .andExpect(status().isCreated())
                    .andReturn();
            assertTrue(mvcResult.getResponse().getContentAsString().contains("accountholder"));

        }

    @Test
    void deleteAccountHolder_test_OK() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic YWRtaW46MTIzNDU2");
        String body = objectMapper.writeValueAsString(accountHolder);

        MvcResult mvcResult = mockMvc.perform(delete("/account-holders/"+ accountHolder.getId()))
                .andExpect(status().isNoContent())
                .andReturn();
        assertFalse(userRepository.existsById(accountHolder.getId()));
    }

}
