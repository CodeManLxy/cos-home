package com.cos.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cos.api.entity.CosMedia;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 上传图片
     * @param files
     * @param groupId
     * @return
     */
    Integer upload(MultipartFile[] files, Long groupId);
}
