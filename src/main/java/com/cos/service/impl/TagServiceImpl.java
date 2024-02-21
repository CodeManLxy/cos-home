package com.cos.service.impl;

import com.cos.dao.TagDao;
import com.cos.entity.CosTag;
import com.cos.service.TagService;
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
}
