package com.cos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cos.entity.CosMedia;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 15:18
 */
@Repository
public interface MediaMapper extends BaseMapper<CosMedia> {

    /**
     * 批量存储
     * @param mediaList
     * @return
     */
    Integer saveBatch(@Param("list") List<CosMedia> mediaList);
}
