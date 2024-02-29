package com.cos.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cos.api.entity.CosGroup;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 新增组
     * @param info
     * @return
     */
    Integer init(CosGroup info);

    /**
     * 上传背景图
     * @param file
     * @param id
     * @return
     */
    Integer uploadBgImg(MultipartFile file, Long id);

    /**
     * 设置标签
     * @param tagId
     * @param groupId
     * @return
     */
    Integer setTags(Long tagId, Long groupId);

    /**
     * 删除标签
     * @param id
     * @return
     */
    Integer deleteTags(Long id);
}
