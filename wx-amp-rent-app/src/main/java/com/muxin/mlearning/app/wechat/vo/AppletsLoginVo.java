package com.muxin.mlearning.app.wechat.vo;

import lombok.Data;

@Data
public class AppletsLoginVo {
    private String code;
    private String rawData;
    private String signature;
    private String iv;
    private String encryptedData;
}
