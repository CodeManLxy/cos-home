package com.cos.config.base.response;

/**
 * 常量类
 */
public class Constants {

    public final static int OK_CODE = 200;
    public final static int FAIL_CODE = 400;
    public final static int OTHER_FAIL_CODE = 333;    // 其它错误
    public final static String OK_MSG = "请求成功";
    public final static String FAIL_MSG = "请求失败";
    public final static int STATUS_0 = 0;   // 可用状态
    public final static int STATUS_1 = 1;   // 禁用状态

    public final static String CACHE_NAME = "KACache";

    public final static String XSS_NOTICE_KEY = "notice";

    /**
     * 用户文件上传基础路径
     */
    public final static String BASE_USER_FILE_PATH = "userFile";

    /**
     * 默认分页启始页数
     */
    public final static Integer DEFAULT_START_PAGE = 0;
    /**
     * 默认分页后每页数据条数
     */
    public final static Integer DEFAULT_PAGE_SIZE = 10;


    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

}
