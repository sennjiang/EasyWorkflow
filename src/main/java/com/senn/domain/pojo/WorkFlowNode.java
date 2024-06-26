package com.senn.domain.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkFlowNode {
    private Long workFlowNodeId;
    private String workFlowNodeName;
    private Integer workFlowNodeType;
    private String workFlowNodeHandleName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
