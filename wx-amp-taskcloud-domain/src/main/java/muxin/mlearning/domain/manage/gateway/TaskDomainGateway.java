package muxin.mlearning.domain.manage.gateway;

import muxin.mlearning.domain.manage.model.RequestTaskDomain;
import muxin.mlearning.domain.manage.model.TaskDomain;

import java.util.List;

public interface TaskDomainGateway {
    TaskDomain insertTaskDomain(TaskDomain taskDomain);

    List<TaskDomain> selectTaskDomains(RequestTaskDomain requestTaskDomain);
}
