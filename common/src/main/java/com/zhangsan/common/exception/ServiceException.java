package com.zhangsan.common.exception;

/**
 * 业务异常
 * @author zhangsan
 * @Date 2022/5/9 20:05
 */
public class ServiceException extends BaseException{
    private static final long serialVersionUID = 7385028007616424107L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
