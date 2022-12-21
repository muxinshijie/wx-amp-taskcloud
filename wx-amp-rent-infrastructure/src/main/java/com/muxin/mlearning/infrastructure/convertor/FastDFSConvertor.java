package com.muxin.mlearning.infrastructure.convertor;

import com.muxin.mlearning.manage.model.FileInfoDTO;
import org.csource.fastdfs.FileInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FastDFSConvertor {
    FileInfoDTO toFileInfoDTO(FileInfo fileInfo);
}
