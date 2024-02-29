package com.cos.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Administrator
 */
@Data
@Builder
@TableName("t_sys_user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {


    private static final long serialVersionUID = -1176637354982897630L;
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private String userId;

    
    private String did;

    /**
     * 组ID
     */
    private String deptId;


    /**
     * 是否为组长
     */
    @TableField(exist = false)
    private Boolean isDeptLeader;

    /**
     * 是否为组元
     */
    @TableField(exist = false)
    private Boolean isDeptMember;

    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户角色
     */
    private String userType;
    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 用户性别
     */
    private Integer sex;

    /**
     * 密码
     */
    private String password;


    /**
     * 帐号状态
     */
    private Integer status;

    /**
     * 删除标志
     */
    private Integer delFlag;


    /**
     * 最后登录时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date loginDate;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新者
     */
    private String updator;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 备注信息
     */
    private String extInfo;





    public enum DelFlag {
        /**
         * 设备状态
         * 1 - 删除
         * 0 - 未删除
         */
        NOT_Del(0),
        Del(1);
        private final int value;

        DelFlag(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    public enum sex {
        /**
         * 性别
         * 0 - 未知
         * 1 - 男
         * 2 - 女
         */
        UNKNOWN(0),
        MAN(1),
        WOMAN(2);
        private final int value;

        sex(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    public enum status {
        /**
         * 帐号状态
         * 0 - 不可用
         * 1 - 可用
         * 2 - 冻结
         */
        AVAILABLE(1),
        NOT_AVAILABLE(0),
        FREEZE(2);


        private final int value;

        status(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

}
