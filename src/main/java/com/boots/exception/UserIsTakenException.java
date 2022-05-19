package com.boots.exception;

public class UserIsTakenException extends GeneralException implements CustomException {

    public final int CODE = 433;

    private String userName;

    public UserIsTakenException(String userName) {
        this.userName = userName;
    }

    @Override
    public String exceptionMessage() {
        return "User with name " + userName + " IS TAKEN";
    }

    @Override
    public int getCode() {
        return CODE;
    }

}
