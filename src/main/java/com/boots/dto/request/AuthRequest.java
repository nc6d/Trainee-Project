package com.boots.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Method in which user data is stored to receive a JWT token
 */
@Data
public class AuthRequest {
    @NotBlank
    @Size(min=3, max=20)
    private String username;

    @NotBlank
    @Size(min=6, max=40)
    private String password;

}
