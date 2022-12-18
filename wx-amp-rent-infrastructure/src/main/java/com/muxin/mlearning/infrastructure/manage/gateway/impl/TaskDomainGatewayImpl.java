package com.muxin.mlearning.infrastructure.manage.gateway.impl;

import com.muxin.mlearning.manage.gateway.TaskDomainGateway;
import com.muxin.mlearning.manage.model.RequestTaskDomain;
import com.muxin.mlearning.manage.model.TaskDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskDomainGatewayImpl implements TaskDomainGateway {
    @Override
    public TaskDomain insertTaskDomain(TaskDomain taskDomain) {
        return null;
    }

    @Override
    public List<TaskDomain> selectTaskDomains(RequestTaskDomain requestTaskDomain) {
        return null;
    }
}
