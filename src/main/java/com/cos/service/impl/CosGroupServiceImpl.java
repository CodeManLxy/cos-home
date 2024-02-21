package com.cos.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cos.dao.CosGroupDao;
import com.cos.dao.GroupTagDao;
import com.cos.entity.CosGroup;
import com.cos.entity.CosTag;
import com.cos.service.CosGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        }else if (2 == type) {
            cosGroup.setLikeCount(cosGroup.getLikeCount() - 1);
            return cosGroupDao.updateLikeCount(cosGroup);
        }
        return null;
    }
}
