package com.muxin.mlearning.app.rent.service.impl;

import com.muxin.mlearning.app.rent.convertor.RentConvertor;
import com.muxin.mlearning.app.rent.service.RentService;
import com.muxin.mlearning.app.rent.vo.RentHotVo;
import com.muxin.mlearning.manage.gateway.RentGateway;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RentServiceImpl implements RentService {
    @Resource
    private RentConvertor rentConvertor;
    @Resource
    private RentGateway rentGateway;

    @Override
    public RentHotVo getRentHot() {
        return null;
    }

    @Override
    public RentHotVo updateRentHot(RentHotVo rentHotVo) {
        return null;
    }
}
