package com.krishna9787.order.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public record SuccessDto(HttpStatus status, String message, LocalDateTime timeStamp) {

}
