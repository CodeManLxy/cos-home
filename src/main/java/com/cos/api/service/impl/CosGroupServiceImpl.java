package com.cos.api.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cos.base.config.base.exception.ExceptionEnum;
import com.cos.base.config.base.exception.ServiceException;
import com.cos.base.config.minio.bean.MinIoResponse;
import com.cos.base.config.minio.conf.MinioConf;
import com.cos.base.config.minio.util.MinioUtils;
import com.cos.api.dao.CosGroupDao;
import com.cos.api.dao.GroupTagDao;
import com.cos.api.entity.CosGroup;
import com.cos.api.entity.CosTag;
import com.cos.api.service.CosGroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 15:32
 */
@Service
public class CosGroupServiceImpl implements CosGroupService {

    @Autowired
    private CosGroupDao cosGroupDao;

    @Autowired
    private GroupTagDao groupTagDao;

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private MinioConf minioConf;


    @Override
    public IPage<CosGroup> list(String groupName, Integer pageNum, Integer pageSize) {
        IPage<CosGroup> list = cosGroupDao.list(groupName, pageNum, pageSize);
        List<CosGroup> records = list.getRecords();
        for (CosGroup record : records) {
            List<CosTag> tagList = groupTagDao.selectTagById(record.getId());
            record.setTagList(tagList);
        }

        return list;
    }

    @Override
    public Integer like(Long id, Integer type) {
        CosGroup cosGroup = cosGroupDao.queryById(id);
        if (1 == type) {
            cosGroup.setLikeCount(cosGroup.getLikeCount() + 1);
            return cosGroupDao.updateLikeCount(cosGroup);
        } else if (2 == type) {
            cosGroup.setLikeCount(cosGroup.getLikeCount() - 1);
            return cosGroupDao.updateLikeCount(cosGroup);
        }
        return null;
    }

    @Override
    public Integer init(CosGroup info) {

        return cosGroupDao.init(info);
    }

    @Override
    public Integer uploadBgImg(MultipartFile file, Long id) {
        if (file.isEmpty()) {
            throw new ServiceException(ExceptionEnum.FILE_EMPTY.getValue(), ExceptionEnum.FILE_EMPTY.getCode());
        }
        CosGroup group = cosGroupDao.queryById(id);
        if (StringUtils.isNotEmpty(group.getBackgroundImg())) {
            String objectName = minioUtils.extObjectName(group.getBackgroundImg());
            minioUtils.deleteObject(minioConf.getBgImgBucket(), objectName);
        }
        try {
            // 上传
            MinIoResponse minIoResponse = minioUtils.uploadFile(file, minioConf.getBgImgBucket(), System.currentTimeMillis() / 1000 + "");
            String objectUrl = minIoResponse.getObjectUrl();
            return cosGroupDao.updateBgImg(objectUrl, id);
        } catch (Exception e) {
            throw new ServiceException(ExceptionEnum.UPLOAD_ERROR.getValue(), ExceptionEnum.UPLOAD_ERROR.getCode());

        }
    }

    @Override
    public Integer setTags(Long tagId, Long groupId) {
        return groupTagDao.setTags(tagId, groupId);
    }

    @Override
    public Integer deleteTags(Long id) {
        return groupTagDao.deleteTags(id);
    }
}
