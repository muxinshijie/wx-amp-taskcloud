package com.muxin.mlearning.app.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.muxin.mlearning.app.wechat.config.WeChatConfig;
import com.muxin.mlearning.app.wechat.vo.AppletsLoginVo;
import com.muxin.mlearning.app.wechat.vo.TokenVo;
import com.muxin.mlearning.infrastructure.feign.WeChatFeign;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final String GRANT_TYPE = "authorization_code";

    @Resource
    private WeChatFeign weChatFeign;
    @Resource
    private WeChatConfig weChatConfig;

    @PostMapping("/login/applets")
    public ResponseEntity<TokenVo> appletsLogin(@RequestBody AppletsLoginVo loginVo) {
        String ret = weChatFeign.weChatLogin(weChatConfig.getAppid(), weChatConfig.getSecret(), loginVo.getCode(), GRANT_TYPE);
        JSONObject jsonObject = JSONObject.parseObject(ret);
        String openId = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");

        //自定义方法用openId和session_key换取token
        TokenVo tokenVo = TokenVo.builder().token("jajajjajaj").build();
        return ResponseEntity.status(HttpStatus.OK).body(tokenVo);
    }
}

