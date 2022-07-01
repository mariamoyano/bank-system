package com.ironhack.midtermmariamoyano.controllers.dto;

import com.ironhack.midtermmariamoyano.models.Role;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Set<Role> roles;

}
