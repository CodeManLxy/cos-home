package com.cos.base.config.base.exception;

/**
 * @author luXinYu
 * @create 2023/9/4 16:59
 */
public enum ExceptionEnum {
    /**
     * 类型枚举实例
     */
    PARAMETER_ERROR(501,"参数错误"),
    SERVICE_ERROR(500,"系统错误"),
    WEB_ERROR(400,"网络繁忙"),

    MODEL_NOT_AVAILABLE(600, "模型不可用"),
    EQUIPMENT_NOT_RUN(601, "设备不可用"),

    DEPLOY_FAIL(602, "部署失败，请重试"),

    UPLOAD_ERROR(701, "上传失败"),
    FILE_EMPTY(702, "文件为空"),
    CHUNK_FILE_ERROR(703, "分片文件上传错误"),

    X_SHELL_ERROR(8001, "服务器连接失败"),
    TAG_IS_EXIST(9001, "当前标签id已存在"),

    EXCEL_PARAM_ERROR(9002, "excel 解析错误"),

    AUTHORITY_ERROR(9003, "无权限")
    ;



    ExceptionEnum(Integer code , String value){
        this.code = code ;
        this.value = value ;
    }

    private Integer code;
    private String value;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 通过code获取value
     * @param code
     * @return
     */
    public static String getValueByCode(String code){
        if(code == null){
            return "";
        }

        for(ExceptionEnum typeEnum:ExceptionEnum.values()){
            if(typeEnum.getCode().equals(code)){
                return typeEnum.getValue();
            }
        }
        return "";
    }

    /**
     * 通过code获取实例
     * @param code
     * @return
     */
    public static ExceptionEnum getErrorEnumByCode(String code){
        for(ExceptionEnum topType:values()){
            if(topType.getCode().equals(code)){
                return topType;
            }
        }
        return null;
    }

}
