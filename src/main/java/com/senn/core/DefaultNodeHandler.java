package com.senn.core;

import com.senn.domain.pojo.Apply;
import com.senn.domain.pojo.ApplyNode;
import com.senn.domain.pojo.WorkFlowNode;
import com.senn.enums.ApplyStatus;

import java.util.List;
import java.util.Objects;

public class DefaultNodeHandler implements NodeHandler{
    @Override
    public ApplyNode createNextNode(Apply apply, ApplyStatus curNodeApproveStatus, List<WorkFlowNode> allNextNode) {
        for (WorkFlowNode nextNode: allNextNode) {
            if (Objects.equals(nextNode.getPreWorkFlowStatus(), curNodeApproveStatus.getStatus())) {
                return new ApplyNode(apply, nextNode);
            }
        }
        return null;
    }

    @Override
    public void afterNodeCreated(ApplyNode createdNode) {
        NodeHandler.super.afterNodeCreated(createdNode);
    }
}
