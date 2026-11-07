package com.krishna9787.user.dto;

import com.krishna9787.user.entity.Customers;
import com.krishna9787.user.util.TierEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoyaltyAccountsDto {

    private Customers customer;
    private int totalPoints;
    private int availablePoints;
    private int redeemedPoints;
    private TierEnum tier;
}
