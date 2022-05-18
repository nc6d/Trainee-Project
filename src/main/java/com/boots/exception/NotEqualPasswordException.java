package com.boots.exception;

public class NotEqualPasswordException extends ErrorCodeException{

    public static final int CODE = 433;

    public NotEqualPasswordException(String userPassword, String passwordConfirm) {
        super(CODE, " The passwords are NOT EQUAL " + userPassword + " != " + passwordConfirm);
    }

}
