package com.krishna9787.products.exception;

import com.krishna9787.products.dto.ErrorResponseDto;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@ControllerAdvice
@Hidden
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.toString(),
                request.getDescription(false),
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDto);
    }

    protected ResponseEntity<Object> handleMethodArgumentNoValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validatorErrors = new HashMap<>();
        List<ObjectError> validationErrorsList = ex.getBindingResult().getAllErrors();

        validationErrorsList.forEach(error -> {
            String fieldError = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            validatorErrors.put(fieldError, message);
        });

        return new ResponseEntity<>(validatorErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleProductAlreadyExistsException(ProductAlreadyExistsException productAlreadyExistsException, WebRequest webRequest) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.toString(),
                webRequest.getDescription(false),
                productAlreadyExistsException.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDto);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleProductNotFoundException(ProductNotFoundException ex, WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.toString(),
                webRequest.getDescription(false),
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDto);
    }

    @ExceptionHandler(CategoryNotFound.class)
    public ResponseEntity<ErrorResponseDto> handleCategoryNotFoundException(CategoryNotFound ex, WebRequest request) {
        var errorResponseDto = new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.toString(),
                request.getDescription(false),
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponseDto);
    }
}
