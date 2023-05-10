package com.project.pr.errorHandling;

import com.project.pr.dto.errorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class globalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<errorResponseDto> handleAllExceptions(Exception ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        errorResponseDto error = new errorResponseDto("Server Error", HttpStatus.INTERNAL_SERVER_ERROR.toString(), details);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(recordNotFoundException.class)
    public final ResponseEntity<errorResponseDto> handleUserNotFoundException(recordNotFoundException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        errorResponseDto error = new errorResponseDto("Record Not Found", HttpStatus.NOT_FOUND.toString(), details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<errorResponseDto> handleHttpClientErrorException(HttpClientErrorException ex) {
        List<String> details = new ArrayList<>();
        details.add("Response body: " + ex.getResponseBodyAsString());
        errorResponseDto error = new errorResponseDto("Client Error", ex.getStatusCode().toString(), details);
        return new ResponseEntity(error, ex.getStatusCode());
    }


}
