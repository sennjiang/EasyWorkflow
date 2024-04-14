package com.senn.domain.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Apply {
    private Long applyId;
    private Long workFlowId;
    private String workFlowName;
    private Long creator;
    private Long applyStatus;
    private Long applyNodeId;
    private String applyDetail;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
