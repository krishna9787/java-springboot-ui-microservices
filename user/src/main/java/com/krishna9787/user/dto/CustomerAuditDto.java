package com.krishna9787.user.dto;

import com.krishna9787.user.entity.Customers;
import com.krishna9787.user.util.ActionEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerAuditDto {

    private Customers customer;
    private ActionEnum action;
    private String fieldName;
    private String oldValue;
    private String newValue;
}
