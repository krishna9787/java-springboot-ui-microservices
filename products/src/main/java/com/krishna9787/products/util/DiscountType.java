package com.krishna9787.products.util;

public enum DiscountType {
    PERCENTAGE("Percentage"),
    FLAT("Flat");

    private String discountType;

    private DiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getDiscountType() {
        return discountType;
    }
}
