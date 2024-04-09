package com.senn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.senn.domain.pojo.Apply;
import com.senn.domain.pojo.ApplyNode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplyMapper extends BaseMapper<Apply> {
    Apply getApplyByApplyNodeId(Long applyNodeId);

    ApplyNode getApplyNodeById(Long applyNodeId);

    void updateApplyNode(ApplyNode nextNode);
}
