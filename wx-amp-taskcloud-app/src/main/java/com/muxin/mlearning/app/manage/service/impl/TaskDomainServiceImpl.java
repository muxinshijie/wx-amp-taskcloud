package com.muxin.mlearning.app.manage.service.impl;

import com.muxin.mlearning.app.manage.convertor.TaskDomainConvertor;
import com.muxin.mlearning.app.manage.service.TaskDomainService;
import com.muxin.mlearning.app.manage.vo.RequestTaskDomainVo;
import com.muxin.mlearning.app.manage.vo.TaskDomainVo;
import com.muxin.mlearning.manage.gateway.TaskDomainGateway;
import com.muxin.mlearning.manage.model.RequestTaskDomain;
import com.muxin.mlearning.manage.model.TaskDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskDomainServiceImpl implements TaskDomainService {
    @Resource
    private TaskDomainConvertor taskDomainConvertor;
    @Resource
    private TaskDomainGateway taskDomainGateway;

    @Override
    public List<TaskDomainVo> selectTaskDomains(RequestTaskDomainVo requestTaskDomainVo) {
        RequestTaskDomain requestTaskDomain = taskDomainConvertor.toRequestTaskDomain(requestTaskDomainVo);
        List<TaskDomain> taskDomains = taskDomainGateway.selectTaskDomains(requestTaskDomain);
        return taskDomainConvertor.toTaskDomainVos(taskDomains);
    }

    @Override
    public TaskDomainVo insertTaskDomain(TaskDomainVo taskDomainVo) {
        TaskDomain taskDomain = taskDomainConvertor.toTaskDomain(taskDomainVo);
        TaskDomain taskDomainBack = taskDomainGateway.insertTaskDomain(taskDomain);
        return taskDomainConvertor.toTaskDomainVo(taskDomainBack);
    }
}
