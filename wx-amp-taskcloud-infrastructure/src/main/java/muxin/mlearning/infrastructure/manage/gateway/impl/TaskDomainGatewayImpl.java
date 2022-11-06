package muxin.mlearning.infrastructure.manage.gateway.impl;

import muxin.mlearning.domain.manage.gateway.TaskDomainGateway;
import muxin.mlearning.domain.manage.model.RequestTaskDomain;
import muxin.mlearning.domain.manage.model.TaskDomain;
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
