package com.project.pr.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class errorResponseDto {

    private String message;
    private String statusCode;
    private Date time;
    private List<String> details;

    public errorResponseDto(String message, String statusCode, List<String> details) {
        this.message = message;
        this.statusCode = statusCode;
        this.details = details;
        this.time = new Date();
    }

}