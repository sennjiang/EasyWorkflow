package com.senn.core;

import com.senn.domain.dto.ApplyCreateInfo;
import com.senn.domain.dto.WorkFlowNodeInfo;
import com.senn.domain.pojo.Apply;
import com.senn.domain.pojo.ApplyNode;
import com.senn.enums.ApplyStatus;
import com.senn.mapper.ApplyMapper;
import com.senn.mapper.WorkFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

    private Scheduler scheduler;

    @Override
    public boolean addApply(ApplyCreateInfo applyInfo) {
        return false;
    }

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
    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public List<WorkFlowNodeInfo> lisAllNextNode(Long applyNodeId) {
        return workFlowMapper.lisAllNextNode(applyNodeId);
    }

    @Override
    public NodeHandler getNodeHandler(String nodeHandleName) {
        return nodeHandlerMap.getOrDefault(nodeHandleName, new DefaultNodeHandler());
    }

    @Override
    @Scheduled(cron = "0 /10 ?")
    public void systemScheduleExecute() {
        Scheduler scheduler = getScheduler();
        List<ApplyNode> applyNodes = scheduler.listApplyNode4Execute();
        for (ApplyNode applyNode : applyNodes) {
            NodeHandler nodeHandler = getNodeHandler(applyNode.getWorkFlowNodeHandleName());
            nodeHandler.nodeExecute(applyNode);
        }
    }

    private Scheduler getScheduler() {
        if (this.scheduler == null) {
            this.scheduler = new DefaultScheduler();
        }
        return this.scheduler;
    }
}
