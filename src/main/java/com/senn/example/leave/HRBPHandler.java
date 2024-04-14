package com.senn.example.leave;


import com.senn.core.NodeHandler;
import com.senn.domain.pojo.ApplyNode;
import com.senn.domain.pojo.User;
import com.senn.mapper.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HRBPHandler implements NodeHandler {
    @Autowired
    ApplyMapper applyMapper;

    @Override
    public void afterNodeCreated(ApplyNode createdNode) {
        // 因为创建下一节点后 需要通知
        Long applyNodeId = createdNode.getApplyNodeId();
        List<User> approver = applyMapper.listApplyNodeApprover(applyNodeId);
        // 通知
        System.out.println("通知审批者: "+ approver);
    }
}
