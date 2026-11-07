package com.krishna9787.user.dto;

import java.time.LocalDate;

import com.krishna9787.user.util.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomersDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String profileImageUrl;
    private Integer loyaltyPoints;
    private StatusEnum status;
}
