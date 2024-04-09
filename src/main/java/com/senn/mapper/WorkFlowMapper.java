package com.senn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.senn.domain.pojo.WorkFlow;
import com.senn.domain.pojo.WorkFlowNode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorkFlowMapper extends BaseMapper<WorkFlow> {

//    @Select("select workflow_node from apply_node left join workflow_node_link on " +
//            "apply_node.workflow_node_id = ")
    List<WorkFlowNode> lisAllNextNode(Long applyNodeId);
}
