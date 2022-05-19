package com.boots.exception;

public class NotEqualPasswordException extends GeneralException implements CustomException {

    public final int CODE = 434;
    private String userPassword;
    private String passwordConfirm;

    public NotEqualPasswordException(String userPassword, String passwordConfirm) {
        this.userPassword = userPassword;
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public String exceptionMessage() {
        return "The passwords are NOT EQUAL: " + userPassword + " != " + passwordConfirm;
    }

    @Override
    public int getCode() {
        return CODE;
    }
}
