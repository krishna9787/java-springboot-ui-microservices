package com.krishna9787.products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private String statusCode;

    private String apiPath;

    private String errorMessage;

    private LocalDateTime errorTime = LocalDateTime.now();
}
