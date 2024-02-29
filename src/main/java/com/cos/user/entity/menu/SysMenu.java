package com.cos.user.entity.menu;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 菜单权限表 sys_menu
 *
 * @author ruoyi
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_sys_menu")
public class SysMenu {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private String menuId;


    /**
     * 菜单名称
     */
    private String menuName;


    /**
     * 父菜单ID
     */
    private String parentId;


    /**
     * 路由地址
     */
    private String url;

    /**
     * 类型（M目录 C菜单 F按钮）
     */
    private String menuType;

    /**
     * 菜单状态 1-显示 0-不显示
     */
    private Integer visibleStatus;


    /**
     * 菜单状态（0正常 1停用）
     */
    private Integer status;

    /**
     * 权限字符串
     */
    private String perms;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新者
     */
    private String updator;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 备注信息
     */
    private String extInfo;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<SysMenu> children = new ArrayList<SysMenu>();

    /**
     * 角色是否拥有该菜单权限
     */
    @TableField(exist = false)
    private Boolean own;


    public enum MenuType {
        /**
         * 菜单类型
         * C - 目录
         * M - 菜单
         * F - 按钮
         */
        CATALOG("C"),
        M_CATALOG("MC"),
        MENU("M"),

        M_MENU("MM"),
        BUTTON("B"),

        M_BUTTON("MB");



        private final String value;

        MenuType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

}
