package muxin.mlearning.app.manage.convertor;

import muxin.mlearning.app.manage.vo.RequestTaskDomainVo;
import muxin.mlearning.app.manage.vo.TaskDomainVo;
import muxin.mlearning.domain.manage.model.RequestTaskDomain;
import muxin.mlearning.domain.manage.model.TaskDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskDomainConvertor {
    TaskDomain toTaskDomain(TaskDomainVo taskDomainVo);

    TaskDomainVo toTaskDomainVo(TaskDomain taskDomain);

    RequestTaskDomain toRequestTaskDomain(RequestTaskDomainVo requestTaskDomainVo);

    List<TaskDomainVo> toTaskDomainVos(List<TaskDomain> taskDomains);
}
