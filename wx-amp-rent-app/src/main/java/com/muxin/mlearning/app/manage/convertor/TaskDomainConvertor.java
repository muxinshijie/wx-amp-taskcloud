package com.muxin.mlearning.app.manage.convertor;

import com.muxin.mlearning.app.manage.vo.RequestTaskDomainVo;
import com.muxin.mlearning.app.manage.vo.TaskDomainVo;
import com.muxin.mlearning.manage.model.RequestTaskDomain;
import com.muxin.mlearning.manage.model.TaskDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskDomainConvertor {
    TaskDomain toTaskDomain(TaskDomainVo taskDomainVo);

    TaskDomainVo toTaskDomainVo(TaskDomain taskDomain);

    RequestTaskDomain toRequestTaskDomain(RequestTaskDomainVo requestTaskDomainVo);

    List<TaskDomainVo> toTaskDomainVos(List<TaskDomain> taskDomains);
}
