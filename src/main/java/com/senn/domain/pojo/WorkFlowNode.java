package com.senn.domain.pojo;

import lombok.Data;

@Data
public class WorkFlowNode {
    private Long workFlowNodeId;
    private String workFlowNodeName;
    private Integer workFlowNodeType;
    private Integer preWorkFlowStatus;
    private String workFlowNodeHandleName;
}
