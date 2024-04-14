package com.senn.core;

import com.senn.domain.dto.ApplyCreateInfo;
import com.senn.domain.dto.WorkFlowNodeInfo;
import com.senn.enums.ApplyStatus;

import java.util.List;

public interface ApplyProcessor {
    boolean addApply(ApplyCreateInfo applyCreateInfo);
    void stateFlow(Long applyNodeId, ApplyStatus curNodeApproveStatus);
    void setNodeHandler(String nodeHandleName, NodeHandler nodeHandler);
    void setScheduler(Scheduler scheduler);
    List<WorkFlowNodeInfo> lisAllNextNode(Long applyNodeId);
    NodeHandler getNodeHandler(String nodeHandleName);
    void systemScheduleExecute();
}
