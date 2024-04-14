package com.senn.domain.dto;

import lombok.Data;

@Data
public class ApplyCreateInfo {
    private Long workFlowId;
    private Long creator;
    private String applyDetail;
}
