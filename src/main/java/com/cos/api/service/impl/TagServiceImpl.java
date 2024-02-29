package com.cos.api.service.impl;

import com.cos.api.dao.TagDao;
import com.cos.api.entity.CosTag;
import com.cos.api.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 16:57
 */
@Service
public class TagServiceImpl implements TagService {


    @Autowired
    private TagDao tagDao;


    @Override
    public List<CosTag> list(String groupName) {

        return tagDao.list(groupName);
    }

    @Override
    public Integer insert(String tagName) {

        return tagDao.insert(tagName);
    }
}
