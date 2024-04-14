package com.senn.core;

import com.senn.domain.pojo.ApplyNode;

import java.util.ArrayList;
import java.util.List;

public class DefaultScheduler implements Scheduler{

    @Override
    public List<ApplyNode> listApplyNode4Execute() {
        return new ArrayList<>();
    }
}
