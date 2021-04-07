package com.kq.dto;

/**
 * DtoResult
 *
 * @author kq
 * @date 2021/4/7 21:13
 * @since 1.0.0
 */
public class DtoResult<T> {

    private boolean success = true;
    private T data;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "DtoResult{" +
                "success=" + success +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
