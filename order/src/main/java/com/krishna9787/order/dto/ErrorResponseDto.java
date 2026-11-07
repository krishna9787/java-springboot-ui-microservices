package com.krishna9787.order.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public record ErrorResponseDto(String apiPath, HttpStatus status, String errorMessage, LocalDateTime errorTime) {

}
