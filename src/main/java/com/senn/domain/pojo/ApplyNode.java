package com.senn.domain.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplyNode {
    private Long applyNodeId;
    private Long applyId;
    private Integer nodeStatus;
    private Long operator;
    private Integer nodeType;
    private Long workFlowNodeId;
    private String workFlowNodeHandleName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public ApplyNode(Apply apply, WorkFlowNode nextWorkFlowNode) {
        this.applyId = apply.getApplyId();
        this.workFlowNodeHandleName = nextWorkFlowNode.getWorkFlowNodeHandleName();
        this.nodeType = nextWorkFlowNode.getWorkFlowNodeType();
    }
}
