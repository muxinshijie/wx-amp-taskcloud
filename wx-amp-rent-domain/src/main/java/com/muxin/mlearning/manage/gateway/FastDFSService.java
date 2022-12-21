package com.muxin.mlearning.manage.gateway;

import com.muxin.mlearning.manage.model.FastDFSFile;
import com.muxin.mlearning.manage.model.FastDFSUploadFile;
import com.muxin.mlearning.manage.model.FileInfoDTO;

import java.io.InputStream;

public interface FastDFSService {
    /**
     * 图片上传
     *
     * @param file 图片文件信息
     * @return
     */
    String upload(FastDFSFile file);

    /**
     * 获取 Tracker 服务地址
     *
     * @return Tracker 服务地址
     */
    String getTrackerUrl();

    /**
     * 获取文件信息
     *
     * @param groupName      组名
     * @param remoteFileName 文件存储完整名
     * @return
     */
    FileInfoDTO getFile(String groupName, String remoteFileName);

    /**
     * 文件下载
     *
     * @param groupName      组名
     * @param remoteFileName 文件存储完整名
     * @return
     */
    InputStream downFile(String groupName, String remoteFileName);

    /**
     * 文件删除
     *
     * @param groupName      组名
     * @param remoteFileName 文件存储完整名
     * @return
     */
    Integer deleteFile(String groupName, String remoteFileName);
}
