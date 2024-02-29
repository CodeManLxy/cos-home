package com.cos.user.entity.role;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangtong
 * @create 2023/10/24 16:17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_sys_user_role")
public class UserRole {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String userId;

    private String roleId;

}
