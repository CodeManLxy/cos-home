package com.cos.user.controller;

import com.cos.base.config.base.response.ResponseData;
import com.cos.base.utils.SecurityUtils;
import com.cos.user.entity.LoginUser;
import com.cos.user.entity.User;
import com.cos.user.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author luXinYu
 * @create 2024/2/29 16:20
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(@RequestBody User user) {
        Map<String, Object> map;
        LoginUser login = userService.login(user);
        map = tokenService.createToken(login);
        map.put("User", login.getUser());
        map.put("Permissions", login.getPermissions());
        return ResponseData.ok(map);
    }


    // 在用户登出或连接关闭时调用此方法
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseData onUserLogout(@RequestParam(name = "userId", required = false) String userId) {
        String token = SecurityUtils.getLoginUser().getToken();
        if (StringUtils.isNotEmpty(token)) {
            // 删除用户缓存记录
            tokenService.delLoginUser(token);
        }
        //移除websocket缓存
        return ResponseData.ok();
    }
}
