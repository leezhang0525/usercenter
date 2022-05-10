package com.zhangsan.common.response;

import com.zhangsan.common.enums.ResultCode;
import com.zhangsan.common.constants.AppConstants;


public class ResultGenerator {

    private ResultGenerator() {

    }

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(AppConstants.DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(AppConstants.DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    public static Result genFailResult(ResultCode code, String message) {
        return new Result()
                .setCode(code)
                .setMessage(message);
    }
}
