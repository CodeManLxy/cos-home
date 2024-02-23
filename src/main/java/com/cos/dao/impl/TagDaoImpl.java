package com.cos.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cos.dao.TagDao;
import com.cos.entity.CosTag;
import com.cos.mapper.TagMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 16:57
 */
@Repository
public class TagDaoImpl implements TagDao {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<CosTag> list(String tagName) {
        QueryWrapper<CosTag> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(tagName), "tag_name", tagName);
        return tagMapper.selectList(queryWrapper);
    }

    @Override
    public Integer insert(String tagName) {
        return tagMapper.insert(CosTag.builder().tagName(tagName).build());
    }
}
