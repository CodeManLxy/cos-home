package com.cos.base.config.base.response;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 返回前端 数据封闭类
 */
public class ResponseData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private Object data;
    private Long total; // 分页信息：总条数

    public ResponseData() { }

    private ResponseData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        if (data instanceof Page<?>) {
            Page<?> page = (Page<?>) data;
            this.total = page.getTotal();
            this.data = page.getRecords();
        } else {
            this.data = data;
            if(data instanceof List<?>){
                List<?> list = (List<?>) data;
                this.total = (long) list.size();
            }
        }
    }

    public static ResponseData ok() {
        return new ResponseData(Constants.OK_CODE, Constants.OK_MSG, null);
    }

    public static ResponseData ok(Object data) {
        return new ResponseData(Constants.OK_CODE, Constants.OK_MSG, data);
    }

    public static ResponseData ok(String msg, Object data) {
        return new ResponseData(Constants.OK_CODE, msg, data);
    }

    public static ResponseData fail(String msg) {
        return new ResponseData(Constants.FAIL_CODE, msg, null);
    }

    public static ResponseData fail(int errorCode, String msg) {
        return new ResponseData(errorCode, msg, null);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public Long getTotal() {
        return total;
    }

    public ResponseData setTotal(Long total) {
        this.total = total;
        return this;
    }
}
