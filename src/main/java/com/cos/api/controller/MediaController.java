package com.cos.api.controller;

import com.cos.base.config.base.response.ResponseData;
import com.cos.api.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author luXinYu
 * @create 2024/2/21 15:03
 */
@RestController
@RequestMapping("/cos")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    /**
     * 查询图片
     *
     * @param groupId
     * @return
     */
    @RequestMapping(value = "/img/list", method = RequestMethod.GET)
    public ResponseData list(@RequestParam(name = "group_id") Long groupId,
                             @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @RequestParam(defaultValue = "10", required = false) Integer pageSize
    ) {
        return ResponseData.ok(mediaService.list(groupId, pageNum, pageSize));
    }

    /**
     * 上传
     * @param files
     * @param groupId
     * @return
     */
    @RequestMapping(value = "/img/upload", method = RequestMethod.POST)
    public ResponseData upload(@RequestParam(name = "files") MultipartFile[] files,
                               @RequestParam(name = "group_id") Long groupId) {
        return ResponseData.ok(mediaService.upload(files, groupId));
    }



}
