package com.muxin.mlearning.app.rent.controller;

import com.muxin.mlearning.app.rent.service.RentService;
import com.muxin.mlearning.app.rent.vo.RentHotVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "房互联-租房接口")
@RestController
@RequestMapping(value = "rent")
public class ManagerController {
    @Resource
    private RentService rentService;

    @ApiOperation("获取更新热门租房")
    @GetMapping("/hot")
    public ResponseEntity<RentHotVo> getRentHot(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(rentService.getRentHot());
    }

    @ApiOperation("管理员更新热门租房")
    @PostMapping("/hot")
    public ResponseEntity<RentHotVo> updateRentHot(HttpServletRequest request, @RequestBody RentHotVo rentHotVo) {
        return ResponseEntity.status(HttpStatus.OK).body(rentService.updateRentHot(rentHotVo));
    }
}
