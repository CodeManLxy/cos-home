package com.cos.controller;

import com.cos.config.base.response.ResponseData;
import com.cos.service.CosGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * 查询图片
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
     * 查询图片
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/group/like", method = RequestMethod.GET)
    public ResponseData like(@RequestParam(name = "id") Long id, @RequestParam(name = "type")Integer type) {
        return ResponseData.ok(cosGroupService.like(id, type));
    }

}
