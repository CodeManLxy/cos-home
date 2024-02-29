package com.cos.user.entity.menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangtong
 * @create 2023/10/30 10:07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RoleMenuVO {


    /**
     * 角色ID
     */

    private String roleId;

    /**
     * 角色ID
     */

    private List<String> menuList;
}
