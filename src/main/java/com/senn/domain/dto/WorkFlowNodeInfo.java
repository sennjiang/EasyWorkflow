package com.senn.domain.dto;

import lombok.Data;

@Data
public class WorkFlowNodeInfo {
    private Long workFlowNodeId;
    private String workFlowNodeName;
    private Integer workFlowNodeType;
    private Integer preNodeStatus;
    private String workFlowNodeHandleName;
}
