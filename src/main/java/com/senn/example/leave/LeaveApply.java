package com.senn.example.leave;

import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.senn.core.ApplyProcessor;
import com.senn.core.DefaultScheduler;
import com.senn.domain.dto.ApplyCreateInfo;
import com.senn.enums.ApplyStatus;
import net.sf.jsqlparser.expression.operators.relational.JsonOperator;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 请假申请
 */
@Component
public class LeaveApply {

    ApplyProcessor applyProcessor;

    //初始化
    @PostConstruct
    private void init(ApplyProcessor applyProcessor, HRBPHandler hrbpHandler, LeaderHandler leaderHandler) {
        applyProcessor.setScheduler(new DefaultScheduler());
        applyProcessor.setNodeHandler("hrbp_node_handler", hrbpHandler);
        applyProcessor.setNodeHandler("leader_handler", leaderHandler);
        this.applyProcessor = applyProcessor;
    }

    public void createApply() {
        ApplyCreateInfo apply = new ApplyCreateInfo();
        apply.setApplyDetail(new LeaveApplyDetail().toString());
        apply.setCreator(1L);
        apply.setWorkFlowId(1L);
        applyProcessor.addApply(apply);
    }

    public void stateApply() {
        applyProcessor.stateFlow(1L, ApplyStatus.APPROVE);
    }
}
