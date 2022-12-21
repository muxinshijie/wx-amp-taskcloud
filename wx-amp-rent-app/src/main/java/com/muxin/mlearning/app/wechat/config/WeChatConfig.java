package com.muxin.mlearning.app.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "we-chat")
public class WeChatConfig {
    private String appid;
    private String secret;
}
