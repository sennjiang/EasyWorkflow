package com.senn.core;

import com.senn.domain.dto.WorkFlowNodeInfo;
import com.senn.domain.pojo.Apply;
import com.senn.domain.pojo.ApplyNode;
import com.senn.enums.ApplyStatus;

import java.util.List;
import java.util.Objects;

public class DefaultNodeHandler implements NodeHandler{
    @Override
    public ApplyNode createNextNode(Apply apply, ApplyStatus curNodeApproveStatus, List<WorkFlowNodeInfo> allNextNode) {
        for (WorkFlowNodeInfo nextNode: allNextNode) {
            if (Objects.equals(nextNode.getPreNodeStatus(), curNodeApproveStatus.getStatus())) {
                return new ApplyNode(apply, nextNode);
            }
        }
        return null;
    }
}
