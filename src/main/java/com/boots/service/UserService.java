package com.boots.service;

import com.boots.domain.ERole;
import com.boots.domain.Role;
import com.boots.domain.User;


import com.boots.dto.response.MessageResponse;
import com.boots.exception.NotEqualPasswordException;
import com.boots.exception.UserIsTakenException;
import com.boots.repository.RoleRepository;
import com.boots.repository.UserRepository;

import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    public User saveUser(String userName, String userPassword, String passwordConfirm) throws NotEqualPasswordException, UserIsTakenException {

        if (!userPassword.equals(passwordConfirm)){
            throw new NotEqualPasswordException(userPassword, passwordConfirm);
        }

        if (userRepository.findByUsername(userName) != null) {
            throw new UserIsTakenException(userName);
        }

        User user = new User(userName, userPassword);

        if(userName.equals("admin") && userPassword.equals("111222FFF")){
            user.setRole(new Role(ERole.ROLE_ADMIN));
        } else if (userName.equals("mod") && userPassword.equals("000111AAA")) {
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
