package com.cos.dao;

import com.cos.entity.CosTag;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 16:26
 */
public interface GroupTagDao {



    List<CosTag> selectTagById(Long id);
}
