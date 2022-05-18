package com.boots.exception;

public class UserIsTakenException extends ErrorCodeException {

    public static final int CODE = 434;

    public UserIsTakenException(String userName) {
        super(CODE, " User with name " + userName + " IS TAKEN");
    }
}
