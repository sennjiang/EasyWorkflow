package com.senn.core;

import com.senn.domain.pojo.Apply;
import com.senn.domain.pojo.ApplyNode;
import com.senn.domain.pojo.WorkFlowNode;
import com.senn.enums.ApplyStatus;

import java.util.List;

public interface NodeHandler {
    // 根据当前审批的结果，与其他条件的不同, 创建后续节点
    default ApplyNode createNextNode(Apply apply, ApplyStatus curNodeApproveStatus,
                                     List<WorkFlowNode> allNextNode) {
        return null;
    }

    // 节点创建后 操作。
    default void afterNodeCreated(ApplyNode createdNode) {}
}
