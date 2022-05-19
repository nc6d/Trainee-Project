package com.boots.exception;

import com.boots.dto.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Adviser {

    @ExceptionHandler({GeneralException.class})
    public ResponseEntity<MessageResponse> handleException(CustomException e){

        return ResponseEntity.status(e.getCode()).body(new MessageResponse(e.exceptionMessage()));

//        return new ResponseEntity<>(mr, HttpStatus.valueOf(e.getCode()));
    }
}
