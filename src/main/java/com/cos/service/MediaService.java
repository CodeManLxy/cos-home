package com.cos.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cos.entity.CosMedia;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 15:17
 */
public interface MediaService {

    /**
     * 查询
     *
     * @param groupId
     * @param pageNum
     * @param pageSize
     * @return
     */
    IPage<CosMedia> list(Long groupId, Integer pageNum, Integer pageSize);
}
