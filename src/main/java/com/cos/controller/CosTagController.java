package com.cos.controller;

import com.cos.config.base.response.ResponseData;
import com.cos.service.CosGroupService;
import com.cos.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luXinYu
 * @create 2024/2/21 15:58
 */
@RestController
@RequestMapping("/cos")
public class CosTagController {

    @Autowired
    private TagService tagService;

    /**
     * 查询所有标签
     *
     * @param tagName
     * @return
     */
    @RequestMapping(value = "/tag/list", method = RequestMethod.GET)
    public ResponseData list(@RequestParam(name = "tag_name", required = false) String tagName
    ) {
        return ResponseData.ok(tagService.list(tagName));
    }

    /**
     * 查询所有标签
     *
     * @param tagName
     * @return
     */
    @RequestMapping(value = "/tag/insert", method = RequestMethod.GET)
    public ResponseData insert(@RequestParam(name = "tag_name") String tagName
    ) {
        return ResponseData.ok(tagService.insert(tagName));
    }
}
