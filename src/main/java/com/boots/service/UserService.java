package com.boots.service;

import com.boots.domain.ERole;
import com.boots.domain.Role;
import com.boots.domain.User;


import com.boots.exception.NotEqualPasswordException;
import com.boots.exception.UserIsTakenException;
import com.boots.repository.RoleRepository;
import com.boots.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

//    @PersistenceContext
//    private EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * The method that finds the user in the database writes it to the entity and returns<associated with findByUsername(username)>
     * @param username
     * @return User user
     * @throws UsernameNotFoundException
     * @author dfcz652
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }


    /**
     * Method that uses loadUserByUsername and bCryptPasswordEncoder encrypts the found user's password<associated with loadUserByUsername>
     * @param username
     * @param password
     * @return User user
     */
    public User PasswordEncryption(String username, String password) {
        User user = (User) loadUserByUsername(username);
        if (user != null) {
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Search for a user in the database by id<associated with findById(userId)>
     * @param userId
     * @return userFromDb or new User()
     */
    public User findUserById(String userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    /**
     * Preparation for showing all users<associated with findAll()>
     * @return allUsers
     */
    public List<User> allUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }















    /**
     * Saving user to DB<associated with userRepository.save(user)>
//     * @param user
     * @return true of false
     * @author dfcz652
     */
    public User saveUser(String username, String userPassword, String passwordConfirm) throws NotEqualPasswordException, UserIsTakenException {

        User user = new User(username, userPassword);

        if (!user.getPassword().equals(passwordConfirm)){
            throw new NotEqualPasswordException(userPassword, passwordConfirm);
        }

        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) {
            throw new UserIsTakenException(user.getUsername());
        }


        if(username.equals("admin") && userPassword.equals("111222FFF")){
            user.setRole(new Role(ERole.ROLE_ADMIN));
        } else if (username.equals("mod") && userPassword.equals("000111AAA")) {
            user.setRole(new Role(ERole.ROLE_MODERATOR));
        } else {
            user.setRole(new Role(ERole.ROLE_USER));
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }






















    /**
     * Removing user from DB via ID<associated with userRepository.deleteById(userId)>
     * @param userId
     * @return true or false
     */
    public boolean deleteUser(String userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    /**
     * (Admin part) Returns user by ID value
     * @param idMin
     * @return em
     */
//    public List<User> usergetList(Long idMin) {
//        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class)
//                .setParameter("paramId", idMin).getResultList();
//    }
}
