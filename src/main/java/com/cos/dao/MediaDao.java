package com.cos.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cos.entity.CosMedia;

/**
 * @author luXinYu
 * @create 2024/2/21 15:17
 */
public interface MediaDao {

    /**
     *
     * @param groupId
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<CosMedia> list(Long groupId, Integer pageNum, Integer pageSize);
}
