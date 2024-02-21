package com.cos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cos.entity.CosTag;
import com.cos.entity.GroupTag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 16:26
 */
@Repository
public interface GroupTagMapper extends BaseMapper<GroupTag> {

    List<CosTag> selectAllTagById(@Param("group_id") Long id);
}
