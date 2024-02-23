package com.cos.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cos.config.base.exception.ExceptionEnum;
import com.cos.config.base.exception.ServiceException;
import com.cos.config.minio.bean.MinIoResponse;
import com.cos.config.minio.conf.MinioConf;
import com.cos.config.minio.util.MinioUtils;
import com.cos.dao.MediaDao;
import com.cos.entity.CosMedia;
import com.cos.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 15:17
 */
@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaDao mediaDao;

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private MinioConf minioConf;


    @Override
    public IPage<CosMedia> list(Long groupId, Integer pageNum, Integer pageSize) {
        IPage<CosMedia> pageInfo = mediaDao.list(groupId, pageNum, pageSize);
        for (CosMedia item : pageInfo.getRecords()) {
            String url = item.getImgUrl();
            String objectName = minioUtils.extObjectName(url);
            String bucketName = minioUtils.extBucketName(url);
            String viewUrl = minioUtils.getDownloadUrl(bucketName, objectName);
            item.setImgUrl(viewUrl);
        }
        return pageInfo;
    }

    @Override
    public Integer upload(MultipartFile[] files, Long groupId) {
        List<CosMedia> mediaList = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                String savePath = groupId + "/" + System.currentTimeMillis() + file.getOriginalFilename();
                MinIoResponse minIoResponse = minioUtils.uploadFile(file, minioConf.getCosImg(), savePath, 1);
                mediaList.add(CosMedia.builder()
                        .imgUrl(minIoResponse.getObjectUrl())
                        .groupId(groupId)
                        .build());
            }
            if (!CollectionUtils.isEmpty(mediaList)) {
               return mediaDao.saveBatch(mediaList);
            }
        } catch (Exception e) {
            throw new ServiceException(ExceptionEnum.UPLOAD_ERROR.getValue(), ExceptionEnum.UPLOAD_ERROR.getCode());
        }
        return 0;
    }
}
