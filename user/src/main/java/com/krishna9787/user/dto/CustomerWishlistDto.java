package com.krishna9787.user.dto;

import com.krishna9787.user.entity.Customers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerWishlistDto {
    private Customers customer;
}
