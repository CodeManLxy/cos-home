package com.cos.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cos.dao.MediaDao;
import com.cos.entity.CosMedia;
import com.cos.mapper.MediaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author luXinYu
 * @create 2024/2/21 15:18
 */
@Repository
public class MediaDaoImpl implements MediaDao {

    @Autowired
    private MediaMapper mapper;

    @Override
    public IPage<CosMedia> list(Long groupId, Integer pageNum, Integer pageSize) {
        IPage<CosMedia> page = new Page<>(pageNum, pageSize);
        QueryWrapper<CosMedia> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("group_id", groupId);
        return mapper.selectPage(page, queryWrapper);
    }
}
