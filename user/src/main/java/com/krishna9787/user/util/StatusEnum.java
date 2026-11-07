package com.krishna9787.user.util;

public enum StatusEnum {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    SUSPENDED("Suspended");

    private final String status;

    private StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
