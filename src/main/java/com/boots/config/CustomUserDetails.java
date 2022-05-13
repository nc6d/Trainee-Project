package com.boots.config;

import com.boots.domain.User;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> grantedAuthorities;

    /**
     * Filling in the user entity for further use
     * @param user
     * @return userDetails
     */
    public static CustomUserDetails fromUserEntityToCustomUserDetails(User user) {
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.username = user.getUsername();
        userDetails.password = user.getPassword();
        userDetails.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getRoleName()));
        return userDetails;
    }

    /**
     * Obtaining the rights that the user is endowed with
     * @return grantedAuthorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    /**
     * Get user password
     * @return password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Get user name
     * @return username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Checking if the account has expired
     * @return true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Checking if the account is blocked
     * @return true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Checking the validity of details
     * @return true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Default method
     * @return true
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}