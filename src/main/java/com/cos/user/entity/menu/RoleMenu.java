package com.cos.user.entity.menu;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangtong
 * @create 2023/10/25 13:29
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_sys_role_menu")
public class RoleMenu {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String menuId;

    private String roleId;

}
