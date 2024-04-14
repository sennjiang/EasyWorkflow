package com.senn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.senn.domain.pojo.Apply;
import com.senn.domain.pojo.ApplyNode;
import com.senn.domain.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyMapper extends BaseMapper<Apply> {
    Apply getApplyByApplyNodeId(Long applyNodeId);

    ApplyNode getApplyNodeById(Long applyNodeId);

    void updateApplyNode(ApplyNode nextNode);

    List<User> listApplyNodeApprover(Long applyNodeId);
}
