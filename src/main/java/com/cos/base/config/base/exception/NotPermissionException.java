package com.cos.base.config.base.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * 未能通过的权限认证异常
 * 
 * @author wangtong
 */
public class NotPermissionException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public NotPermissionException(String permission)
    {
        super(permission);
    }

    public NotPermissionException(String[] permissions)
    {
        super(StringUtils.join(permissions, ","));
    }
}
