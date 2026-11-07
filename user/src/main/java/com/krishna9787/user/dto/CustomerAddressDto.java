package com.krishna9787.user.dto;

import java.util.List;

import com.krishna9787.user.entity.Customers;
import com.krishna9787.user.util.AddressTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerAddressDto {

    private List<Customers> customer;
    private AddressTypeEnum addressType;
    private String recipientName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Boolean isDefaultBillingAddress;
    private Boolean isDefaultShippingAddress;
}
