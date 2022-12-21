package com.muxin.mlearning.start;

import com.muxin.mlearning.infrastructure.feign.WeChatFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.muxin.mlearning")
@EnableFeignClients(clients = WeChatFeign.class)
public class MlearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(MlearningApplication.class, args);
    }
}
