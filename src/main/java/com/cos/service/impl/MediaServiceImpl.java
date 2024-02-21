package com.cos.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cos.dao.MediaDao;
import com.cos.entity.CosMedia;
import com.cos.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luXinYu
 * @create 2024/2/21 15:17
 */
@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaDao mediaDao;


    @Override
    public IPage<CosMedia> list(Long groupId, Integer pageNum, Integer pageSize) {
        return mediaDao.list(groupId, pageNum, pageSize);
    }
}
