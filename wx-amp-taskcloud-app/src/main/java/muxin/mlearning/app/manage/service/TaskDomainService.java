package muxin.mlearning.app.manage.service;

import muxin.mlearning.app.manage.vo.RequestTaskDomainVo;
import muxin.mlearning.app.manage.vo.TaskDomainVo;

import java.util.List;

public interface TaskDomainService {
    /**
     * 查询任务域
     *
     * @param requestTaskDomainVo 任务域查询Vo
     * @return 查询结果
     */
    List<TaskDomainVo> selectTaskDomains(RequestTaskDomainVo requestTaskDomainVo);

    /**
     * 新建任务域
     *
     * @param taskDomainVo 任务域Vo
     * @return 插入结果
     */
    TaskDomainVo insertTaskDomain(TaskDomainVo taskDomainVo);
}
