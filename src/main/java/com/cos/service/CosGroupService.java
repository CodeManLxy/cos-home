package com.cos.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cos.entity.CosGroup;

/**
 * @author luXinYu
 * @create 2024/2/21 15:32
 */
public interface CosGroupService {
    /**
     * 查询
     * @param groupId

     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<CosGroup> list(String groupId, Integer pageNum, Integer pageSize);

    /**
     * 点赞
     *
     * @param id
     * @param type
     * @return
     */
    Integer like(Long id, Integer type);
}
