package com.muxin.mlearning.manage.model;

import lombok.Data;

import java.util.Date;

@Data
public class FileInfoDTO {
    private String source_ip_addr;
    private long file_size;
    private Date create_timestamp;
    private int crc32;
}
