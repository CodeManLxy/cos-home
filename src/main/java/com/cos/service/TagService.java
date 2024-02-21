package com.cos.service;

import com.cos.entity.CosTag;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 16:56
 */
public interface TagService {
    /**
     * 查询所有标签
     * @param tagName
     * @return
     */
    List<CosTag> list(String tagName);
}
