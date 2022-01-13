package com.kq.gateway.lb.exception;


import com.kq.gateway.lb.common.ResultCode;
import lombok.Data;

/**
* @vlog: 高于生活，源于生活
* @desc: 类的描述:网关异常类
* @author: smlz
* @createDate: 2020/1/22 10:52
* @version: 1.0
*/
@Data
public class GateWayException extends RuntimeException{

    private long code;

    private String message;

    public GateWayException(ResultCode iErrorCode) {
        this.code = iErrorCode.getCode();
        this.message = iErrorCode.getMessage();
    }
}
