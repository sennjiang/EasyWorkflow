package com.senn.domain.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkFlow {
    private Long workFlowId;
    private String workFlowName;
    private Long firstNodeId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
