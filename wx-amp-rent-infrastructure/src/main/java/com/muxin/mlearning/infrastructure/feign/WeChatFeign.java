package com.muxin.mlearning.infrastructure.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${we-chat.login-url}", name = "we-chat")
public interface WeChatFeign {
    @GetMapping("/sns/jscode2session")
    String weChatLogin(@RequestParam String appid,
                       @RequestParam String secret,
                       @RequestParam String js_code,
                       @RequestParam String grant_type);
}
