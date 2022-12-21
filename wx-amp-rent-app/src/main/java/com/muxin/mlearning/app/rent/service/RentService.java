package com.muxin.mlearning.app.rent.service;

import com.muxin.mlearning.app.rent.vo.RentHotVo;

public interface RentService {

    /**
     * 获取热门租房
     *
     * @return 热门租房列表
     */
    RentHotVo getRentHot();

    /**
     * 更新热门租房
     *
     * @param rentHotVo 热门租房
     * @return 更新后热门租房
     */
    RentHotVo updateRentHot(RentHotVo rentHotVo);
}
