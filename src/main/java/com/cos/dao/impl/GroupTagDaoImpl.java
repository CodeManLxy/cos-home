package com.cos.dao.impl;

import com.cos.dao.GroupTagDao;
import com.cos.entity.CosTag;
import com.cos.mapper.GroupTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 16:26
 */
@Repository
public class GroupTagDaoImpl implements GroupTagDao {


    @Autowired
    private GroupTagMapper groupTagMapper;

    @Override
    public List<CosTag> selectTagById(Long id) {
        return groupTagMapper.selectAllTagById(id);
    }
}
