package com.cos.api.controller;

import com.cos.base.config.base.response.ResponseData;
import com.cos.api.entity.CosGroup;
import com.cos.api.service.CosGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author luXinYu
 * @create 2024/2/21 15:30
 */
@RestController
@RequestMapping("/cos")
public class CosGroupController {


    @Autowired
    private CosGroupService cosGroupService;

    /**
     * 组列表查询
     *
     * @param groupName
     * @return
     */
    @RequestMapping(value = "/group/list", method = RequestMethod.GET)
    public ResponseData list(@RequestParam(name = "group_name", required = false) String groupName,
                             @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                             @RequestParam(defaultValue = "20", required = false) Integer pageSize
    ) {
        return ResponseData.ok(cosGroupService.list(groupName, pageNum, pageSize));
    }

    /**
     * 点赞
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/group/like", method = RequestMethod.GET)
    public ResponseData like(@RequestParam(name = "id") Long id, @RequestParam(name = "type") Integer type) {
        return ResponseData.ok(cosGroupService.like(id, type));
    }

    /**
     * 新增组
     * @param info
     * @return
     */
    @RequestMapping(value = "/group/init", method = RequestMethod.POST)
    public ResponseData init(@RequestBody CosGroup info) {
        return ResponseData.ok(cosGroupService.init(info));
    }

    /**
     * 上传背景图
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/group/upload_bg_img", method = RequestMethod.POST)
    public ResponseData uploadBgImg(@RequestParam(name = "file") MultipartFile file,
                                    Long id) {
        return ResponseData.ok(cosGroupService.uploadBgImg(file, id));
    }


    /**
     * 组标签设置
     *
     * @param tagId
     * @param groupId
     * @return
     */
    @RequestMapping(value = "/group/set_tags", method = RequestMethod.GET)
    public ResponseData setTags(@RequestParam(name = "tag_id") Long tagId, @RequestParam("group_id") Long groupId) {
        return ResponseData.ok(cosGroupService.setTags(tagId, groupId));
    }

    /**
     * 组标签删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/group/delete_tags", method = RequestMethod.GET)
    public ResponseData deleteTags(@RequestParam(name = "id") Long id) {
        return ResponseData.ok(cosGroupService.deleteTags(id));
    }

}
