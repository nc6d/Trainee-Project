package com.boots.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private String id;
    private String username;
    private String password;
    private String role;

//    private List<String> roles;
//    public UserInfoResponse(String id, String username, String email, List<String> roles) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.roles = roles;
//    }

}
