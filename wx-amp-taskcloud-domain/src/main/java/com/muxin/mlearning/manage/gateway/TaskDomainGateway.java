package com.muxin.mlearning.manage.gateway;

import com.muxin.mlearning.manage.model.RequestTaskDomain;
import com.muxin.mlearning.manage.model.TaskDomain;

import java.util.List;

public interface TaskDomainGateway {
    TaskDomain insertTaskDomain(TaskDomain taskDomain);

    List<TaskDomain> selectTaskDomains(RequestTaskDomain requestTaskDomain);
}
