package com.cos.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cos.dao.CosGroupDao;
import com.cos.entity.CosGroup;
import com.cos.mapper.CosGroupMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author luXinYu
 * @create 2024/2/21 15:33
 */
@Repository
public class CosGroupDaoImpl implements CosGroupDao {

    @Autowired
    private CosGroupMapper cosGroupMapper;

    @Override
    public IPage<CosGroup> list(String groupName, Integer pageNum, Integer pageSize) {
        IPage<CosGroup> page = new Page<>(pageNum, pageSize);
        QueryWrapper<CosGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(groupName), "group_name", groupName);
        return cosGroupMapper.selectPage(page, queryWrapper);
    }

    @Override
    public CosGroup queryById(Long id) {
        return cosGroupMapper.selectById(id);
    }

    @Override
    public Integer updateLikeCount(CosGroup cosGroup) {
        return cosGroupMapper.updateById(cosGroup);
    }

    @Override
    public Integer init(CosGroup info) {
        return cosGroupMapper.insert(info);
    }

    @Override
    public Integer updateBgImg(String objectUrl, Long id) {

        return cosGroupMapper.updateById(CosGroup.builder()
                .id(id)
                .backgroundImg(objectUrl).build());
    }
}
