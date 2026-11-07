package com.krishna9787.products.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Getter
@Setter
public class ResponseDto {

    private HttpStatus status;

    private String statusMessage;

    private LocalDateTime successTime = LocalDateTime.now();

    public ResponseDto(HttpStatus status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
    }
}

