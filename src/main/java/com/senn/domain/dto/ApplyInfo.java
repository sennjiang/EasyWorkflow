package com.senn.domain.dto;

import com.senn.core.NodeHandler;
import com.senn.domain.pojo.Apply;
import com.senn.domain.pojo.ApplyNode;
import com.senn.domain.pojo.WorkFlowNode;
import com.senn.enums.ApplyStatus;

import java.util.List;

public class ApplyInfo {
    private Apply apply;
    // 申请的状态。(审批中、已通过、已拒绝)
    private ApplyStatus curNodeApproveStatus;
    // 当前所处的节点
    private ApplyNode curNode;

//    public ApplyInfo(Apply apply, ApplyNode curNode, ApplyStatus curNodeApproveStatus) {
//        this.apply = apply;
//        this.curNode = curNode;
//        this.curNodeApproveStatus = curNodeApproveStatus;
//    }
//
//    public ApplyNode nextNode(NodeHandler nodeHandler, List<WorkFlowNode> allNextNode) {
//        ApplyNode nextNode = nodeHandler.createNextNode(apply, curNodeApproveStatus, allNextNode);
//        nodeHandler.afterNodeCreated(nextNode);
//        return nextNode;
//    }

}
