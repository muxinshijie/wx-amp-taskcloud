package com.muxin.mlearning.app.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final IPInterceptor ipInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //对所有请求url拦截(拦截器中会正常放行，所以不影响业务功能)
        registry.addInterceptor(ipInterceptor).addPathPatterns("/**");
    }
}
