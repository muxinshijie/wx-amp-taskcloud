package com.muxin.mlearning.app.manage.controller;

import com.muxin.mlearning.app.manage.vo.RequestTaskDomainVo;
import com.muxin.mlearning.app.manage.service.TaskDomainService;
import com.muxin.mlearning.app.manage.vo.TaskDomainVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "manager")
public class ManagerController {
    @Resource
    private TaskDomainService taskDomainService;

    // 插入任务域
    @PostMapping("/domain/insert")
    public TaskDomainVo insertTaskDomain(HttpServletRequest request, TaskDomainVo taskDomainVo) {
        return taskDomainService.insertTaskDomain(taskDomainVo);
    }

    // 获取任务域
    @PostMapping("/domain")
    public List<TaskDomainVo> selectTaskDomains(HttpServletRequest request, RequestTaskDomainVo requestTaskDomainVo) {
        return taskDomainService.selectTaskDomains(requestTaskDomainVo);
    }
}
