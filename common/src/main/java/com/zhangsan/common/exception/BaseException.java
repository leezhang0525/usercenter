package com.zhangsan.common.exception;

import java.util.List;

/**
 * base异常
 * @author zhangsan
 * @Date 2022/5/9 20:01
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 6300529163841623951L;
    private String remoteIp;
    private String userId;
    private List<Object> args;


    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public List<Object> getArgs() {
        return args;
    }

    public void setArgs(List<Object> args) {
        this.args = args;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    protected BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getMessage0() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("remoteIp:").append(remoteIp).append("\r\n").append("userId:").append(userId).append("\r\n");
        stringBuilder.append("args:");
        if (args != null) {
            for (Object arg : args) {
                stringBuilder.append(arg).append("\r\n");
            }
        }
        return stringBuilder.toString();
    }
}
