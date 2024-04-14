package com.senn.example.leave;

import com.senn.core.NodeHandler;
import com.senn.domain.dto.WorkFlowNodeInfo;
import com.senn.domain.pojo.Apply;
import com.senn.domain.pojo.ApplyNode;
import com.senn.enums.ApplyStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeaderHandler implements NodeHandler {
    @Override
    public ApplyNode createNextNode(Apply apply, ApplyStatus curNodeApproveStatus, List<WorkFlowNodeInfo> allNextNode) {
        String applyDetail = apply.getApplyDetail();
        LeaveApplyDetail leaveApplyDetail = fromJson(applyDetail, LeaveApplyDetail.class);
        // 判断审批详情中的时间 是否需要 Leader+1。
        if (leaveApplyDetail.getLeaveTime() > 15) {
            // 创建Leader+1
            return new ApplyNode();
        } else {
            // 创建结束节点
            return new ApplyNode();
        }
    }

    @Override
    public void afterNodeCreated(ApplyNode createdNode) {
        // 如果 Leader + 1 节点 则需要通知，不然则不处理
        if (createdNode.getWorkFlowNodeId() == 1) {
            // 通知
        }
    }


    private LeaveApplyDetail fromJson(String applyDetail, Class<LeaveApplyDetail> leaveApplyDetailClass) {
        // 模拟
        LeaveApplyDetail detail = new LeaveApplyDetail();
        detail.setLeaveTime(20L);
        return detail;
    }
}
