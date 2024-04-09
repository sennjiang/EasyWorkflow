package com.senn.enums;

public enum ApplyStatus {
    APPROVE(1),
    REJECT(2);
    private Integer status;

    ApplyStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
