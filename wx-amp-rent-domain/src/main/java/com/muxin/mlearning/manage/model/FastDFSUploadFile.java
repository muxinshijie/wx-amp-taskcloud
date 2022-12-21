package com.muxin.mlearning.manage.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FastDFSUploadFile {
    /**
     * 组名
     */
    private String groupName;
    /**
     * 存储路径
     */
    private String remoteFileName;
}
