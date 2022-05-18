package com.boots.domain;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import java.util.Set;

@Entity
//@Table(name = "t_role")
@Document(collection="t_role")
@Data
public class Role implements GrantedAuthority {

    @Id
    private String id;

    private ERole name;

    public Role() {}

    public Role(ERole name) {
        this.name = name;
    }

    public ERole getName() {
        return name;
    }

    public String getRoleName() {
        return String.valueOf(name);
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }

}