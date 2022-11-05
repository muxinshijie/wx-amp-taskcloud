package muxin.mlearning.app.manage.controller;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {
    @PostMapping("/task/domain/insert")
    public Map<String,Object> insertTaskDomain(HttpServletRequest request){
        return Maps.newHashMap();
    }
}
