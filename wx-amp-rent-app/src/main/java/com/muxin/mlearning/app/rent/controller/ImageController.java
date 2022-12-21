package com.muxin.mlearning.app.rent.controller;

import com.muxin.mlearning.app.rent.vo.UploadImageVo;
import com.muxin.mlearning.manage.gateway.FastDFSService;
import com.muxin.mlearning.manage.model.FastDFSFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "房互联-图片接口")
@RestController
@RequestMapping(value = "/image")
public class ImageController {
    @Value("${ali-server.ssl-path}")
    private String sslPath;

    @Resource
    private FastDFSService fastDFSService;

    @ApiOperation("上传图片")
    @PostMapping("/upload")
    public ResponseEntity<UploadImageVo> upload(HttpServletRequest request, MultipartFile file) {
        try {
            // 文件上传
            // 1. 获取文件属性
            // 1.1. 原始文件名
            String originalFilename = file.getOriginalFilename();
            // 1.2. 文件内容
            byte[] fileBytes = file.getBytes();
            // 1.3 文件扩展名  test.jpg -> jpg
            assert originalFilename != null;
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            // 2. 创建 FastDFSFile
            FastDFSFile fastDFSFile = new FastDFSFile(originalFilename, fileBytes, ext);
            // 3. 调用工具类上传
            // uploadResult 第一个只是 group 第二个值是：物理路径
            String url = sslPath + fastDFSService.upload(fastDFSFile);

            return ResponseEntity.status(HttpStatus.OK).body(UploadImageVo.builder().url(url).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
