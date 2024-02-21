package com.cos.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cos.entity.CosGroup;

/**
 * @author luXinYu
 * @create 2024/2/21 15:33
 */
public interface CosGroupDao {
    /**
     * 查询
     * @param groupId
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<CosGroup> list(String groupId, Integer pageNum, Integer pageSize);


    /**
     * 查询
     * @param id
     * @return
     */
    CosGroup queryById(Long id);

    /**
     * 修改点赞数量
     * @param cosGroup
     * @return
     */
    Integer updateLikeCount(CosGroup cosGroup);
}
