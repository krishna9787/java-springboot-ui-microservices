package com.krishna9787.user.util;

public enum AddressTypeEnum {
    SHIPPING("Shipping"),
    BILLING("Billing"),
    HOME("Home"),
    OFFICE("Office");

    private final String type;

    private AddressTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
