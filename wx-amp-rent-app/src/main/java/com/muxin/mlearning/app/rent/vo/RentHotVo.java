package com.muxin.mlearning.app.rent.vo;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RentHotVo {
    private Integer count;
    private List<RentVo> rentVos;
}
