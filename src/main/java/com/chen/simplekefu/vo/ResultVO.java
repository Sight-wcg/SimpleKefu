package com.chen.simplekefu.vo;

/**
 * @author chen
 * @create 2020-04-22-17:38
 */
public class ResultVO<T> {
    private String msg;
    private Integer code;
    private T data;//泛型数据

    public ResultVO() {
    }

    public ResultVO(String msg, Integer code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
