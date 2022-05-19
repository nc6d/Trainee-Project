package com.boots.controller;

import com.boots.domain.User;

import com.boots.dto.request.RegistrationRequest;
import com.boots.dto.response.MessageResponse;
import com.boots.dto.response.UserInfoResponse;
import com.boots.exception.NotEqualPasswordException;
import com.boots.exception.UserIsTakenException;
import com.boots.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> checkingForUserCreationErrorsAndSaveUser(@Valid @RequestBody RegistrationRequest registrationRequest) throws NotEqualPasswordException, UserIsTakenException {

        User user = userService.saveUser(registrationRequest.getUsername(), registrationRequest.getPassword(), registrationRequest.getPasswordConfirm());

        return ResponseEntity.ok().body(new UserInfoResponse(user.getId(), user.getUsername(),user.getPassword(), user.getRole().getRoleName()));
    }




















    /**
     * Method returning registration page
     * @param model
     * @return registration
     */
//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }

    /**
     * A method that checks if the password matches, if the username is busy and saves the logged in user to the DB<associated with userService.saveUser(userForm)>
     * @param //userForm
//     * @param bindingResult
     * @param //model
     * @return redirect:/
     */
//    @PostMapping("/registration")
//    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "registration";
//        }
//        if (!userService.saveUser(userForm)){
//            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
//            return "registration";
//        }
//
//        return "redirect:/";
//    }

//    @PostMapping("/registration")
//    public @ResponseBody String checkingForUserCreationErrorsAndSaveUser(@RequestParam("username") String username,
//                                                                         @RequestParam("password") String password,
//                                                                         @RequestParam("passwordConfirm") String passwordConfirm,
//                                                                         User user, BindingResult bindingResult) {





}

