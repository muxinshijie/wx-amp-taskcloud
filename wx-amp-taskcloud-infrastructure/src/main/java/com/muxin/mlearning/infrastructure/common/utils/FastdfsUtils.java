package com.muxin.mlearning.infrastructure.common.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
//import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;

public class FastdfsUtils {
    private static StorageClient1 client1;

    @PostConstruct
    public void init() {
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            client1 = new StorageClient1(trackerServer, null);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
    }


//    public static void upload(MultipartFile file) {
//        String oldName = file.getOriginalFilename();
//        try {
//            assert oldName != null;
//            client1.upload_file1(file.getBytes(), oldName.substring(oldName.lastIndexOf(".") + 1), null);
//        } catch (IOException | MyException e) {
//            e.printStackTrace();
//        }
//    }
}
