package com.boots.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import javax.validation.constraints.Size;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
//@Table(name = "t_user")
@Document(collection="t_user")
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Size(min=2, message = "At least five characters")
    private String username;

    @Size(min=2, message = "At least five characters")
    private String password;

    @Transient
    @JsonIgnore
    private String passwordConfirm;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @DBRef
//    private Set<Role> roles = new HashSet<>();

    @ManyToOne
    private Role role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
}
