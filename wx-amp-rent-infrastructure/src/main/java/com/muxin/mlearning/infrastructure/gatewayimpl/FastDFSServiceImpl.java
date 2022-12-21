package com.muxin.mlearning.infrastructure.gatewayimpl;

import com.muxin.mlearning.infrastructure.convertor.FastDFSConvertor;
import com.muxin.mlearning.manage.gateway.FastDFSService;
import com.muxin.mlearning.manage.model.FastDFSFile;
import com.muxin.mlearning.manage.model.FileInfoDTO;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FastDFS客户端工具类
 */
@Service
public class FastDFSServiceImpl implements FastDFSService {
    private static Logger logger = LoggerFactory.getLogger(FastDFSFile.class);
    private static StorageClient1 storageClient1;
    private static TrackerServer trackerServer;
    private static TrackerClient trackerClient;

    @Resource
    private FastDFSConvertor fastDFSConvertor;

    @PostConstruct
    public void init() {
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient1 = new StorageClient1(trackerServer, null);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String upload(FastDFSFile file) {
        // 获取文件的作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());

        String uploadUrl = null;
        try {
            /*
             * 文件上传
             * 1) 文件字节数组
             * 2) 文件扩展名
             * 3) 文件作者
             */
            uploadUrl = storageClient1.upload_file1(file.getContent(), file.getExt(), meta_list);
        } catch (Exception e) {
            logger.error("上传文件{}失败: {}" + file.getName(), e);
        }
        return uploadUrl;
    }

    @Override
    public String getTrackerUrl() {
        return "http://" + trackerServer.getInetSocketAddress().getHostString() + ":" + ClientGlobal.getG_tracker_http_port() + "/";
    }

    @Override
    public FileInfoDTO getFile(String groupName, String remoteFileName) {
        try {
            FileInfo fileInfo = storageClient1.get_file_info(groupName, remoteFileName);
            return fastDFSConvertor.toFileInfoDTO(fileInfo);
        } catch (Exception e) {
            logger.error("从FastDFS中获取文件错误", e);
        }
        return null;
    }

    @Override
    public InputStream downFile(String groupName, String remoteFileName) {
        try {
            // 下载文件
            byte[] fileByte = storageClient1.download_file(groupName, remoteFileName);
            return new ByteArrayInputStream(fileByte);
        } catch (Exception e) {
            logger.error("从FastDFS获取文件失败", e);
        }
        return null;
    }

    @Override
    public Integer deleteFile(String groupName, String remoteFileName) {
        try {
            // 删除文件
            return storageClient1.delete_file(groupName, remoteFileName);
        } catch (Exception e) {
            logger.error("从FastDFS中文件删除失败", e);
            return 0;
        }
    }

    /**
     * 获取Storage组
     *
     * @param groupName 组名
     * @return Storage组
     */
    private StorageServer[] getStoreStorages(String groupName) {
        try {
            //获取 Storage 组
            return trackerClient.getStoreStorages(trackerServer, groupName);
        } catch (Exception e) {
            logger.error("从FastDFS获取Storage 组失败", e);
        }
        return null;
    }

    /**
     * 获取 Storage 信息,IP和端口
     *
     * @param groupName      组名
     * @param remoteFileName 文件存储完整名
     * @return 文件存储完整名
     */
    private ServerInfo[] getFetchStorages(String groupName, String remoteFileName) {
        try {
            return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
        } catch (Exception e) {
            logger.error("获取Storage信息，IP 和端口失败", e);
        }
        return null;
    }
}


