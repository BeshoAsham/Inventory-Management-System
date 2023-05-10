package com.project.pr.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class recordNotFoundException extends RuntimeException {

    public recordNotFoundException(String msg) {
        super(msg);
    }

}