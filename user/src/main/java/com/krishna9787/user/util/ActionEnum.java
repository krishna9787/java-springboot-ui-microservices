package com.krishna9787.user.util;

public enum ActionEnum {
    CREATE("Create"),
    UPDATE("Update"),
    DELETE("Delete");

    private final String action;

    private ActionEnum(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
