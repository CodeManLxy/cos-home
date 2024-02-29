package com.cos.api.dao;

import com.cos.api.entity.CosTag;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 16:26
 */
public interface GroupTagDao {



    List<CosTag> selectTagById(Long id);

    /**
     * 为组 设置标签
     * @param tagId
     * @param groupId
     * @return
     */
    Integer setTags(Long tagId, Long groupId);

    /**
     * 组 标签删除
     * @param id
     * @return
     */
    Integer deleteTags(Long id);
}
