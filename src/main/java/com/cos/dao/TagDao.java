package com.cos.dao;

import com.cos.entity.CosTag;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 16:57
 */
public interface TagDao {
    /**
     * 查询所有标签
     * @param groupName
     * @return
     */
    List<CosTag> list(String groupName);
}
