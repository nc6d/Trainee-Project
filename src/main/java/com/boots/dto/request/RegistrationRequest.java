package com.boots.dto.request;

import com.boots.domain.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class RegistrationRequest {
    @NotBlank
    @Size(min=3, max=20)
    private String username;

    @NotBlank
    @Size(min=6, max=40)
    private String password;

    @NotBlank
    @Size(min=6, max=40)
    private String passwordConfirm;

    private Role role;


}
