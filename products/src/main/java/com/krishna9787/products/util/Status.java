package com.krishna9787.products.util;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String statusName;
    private Status(String statusName) {
        this.statusName = statusName;
    }

    private String getStatus() {
        return statusName;
    }

}
