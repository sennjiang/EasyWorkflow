package com.senn.core;

import com.senn.domain.pojo.Apply;
import com.senn.domain.pojo.ApplyNode;
import com.senn.domain.pojo.WorkFlowNode;
import com.senn.enums.ApplyStatus;
import com.senn.mapper.ApplyMapper;
import com.senn.mapper.WorkFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StandardApplyProcessor implements ApplyProcessor {

    private final Map<String, NodeHandler> nodeHandlerMap = new HashMap<>();

    @Autowired
    ApplyMapper applyMapper;

    @Autowired
    WorkFlowMapper workFlowMapper;

    @Override
    @Transactional
    public void stateFlow(Long applyNodeId, ApplyStatus curNodeApproveStatus) {
        // 获取申请信息
        Apply apply = applyMapper.getApplyByApplyNodeId(applyNodeId);
        ApplyNode applyNode = applyMapper.getApplyNodeById(applyNodeId);
        // 处理下一节点
        NodeHandler nodeHandler = getNodeHandler(applyNode.getWorkFlowNodeHandleName());
        ApplyNode nextNode = nodeHandler.createNextNode(apply, curNodeApproveStatus, lisAllNextNode(applyNodeId));
        nodeHandler.afterNodeCreated(nextNode);
        // 保存到数据库
        save2db(apply, nextNode);
    }

    private void save2db(Apply apply, ApplyNode nextNode) {
        applyMapper.updateById(apply);
        applyMapper.updateApplyNode(nextNode);
    }

    @Override
    public void setNodeHandler(String nodeHandleName, NodeHandler nodeHandler) {
        this.nodeHandlerMap.put(nodeHandleName, nodeHandler);
    }

    @Override
    public List<WorkFlowNode> lisAllNextNode(Long applyNodeId) {
        return workFlowMapper.lisAllNextNode(applyNodeId);
    }

    @Override
    public NodeHandler getNodeHandler(String nodeHandleName) {
        return nodeHandlerMap.getOrDefault(nodeHandleName, new DefaultNodeHandler());
    }
}
