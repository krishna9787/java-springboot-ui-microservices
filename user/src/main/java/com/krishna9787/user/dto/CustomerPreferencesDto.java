package com.krishna9787.user.dto;

import com.krishna9787.user.entity.Customers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerPreferencesDto {

    private Customers customer;
    private String preferredLanguage;
    private String preferredCurrency;
    private String timeZone;
    private Boolean emailNotificationsEnabled;
    private Boolean smsNotificationsEnabled;
    private Boolean pushNotificationsEnabled;
    private Boolean marketingEmailsEnabled;
    private Boolean darkModeEnabled;
}
