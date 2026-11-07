package com.krishna9787.user.util;

public enum TierEnum {

    BRONZE("Bronze"),
    SILVER("Silver"),
    GOLD("Gold"),
    PLATINUM("Platinum");

    private final String tier;

    private TierEnum(String tier) {
        this.tier = tier;
    }

    public String getTier() {
        return tier;
    }
}
