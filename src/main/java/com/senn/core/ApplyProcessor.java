package com.senn.core;

import com.senn.domain.pojo.WorkFlowNode;
import com.senn.enums.ApplyStatus;

import java.util.List;

public interface ApplyProcessor {
    void stateFlow(Long applyNodeId, ApplyStatus curNodeApproveStatus);
    void setNodeHandler(String nodeHandleName, NodeHandler nodeHandler);
    List<WorkFlowNode> lisAllNextNode(Long applyNodeId);
    NodeHandler getNodeHandler(String nodeHandleName);
}
