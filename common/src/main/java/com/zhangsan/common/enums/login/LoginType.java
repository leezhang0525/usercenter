package com.zhangsan.common.enums.login;

/**
 * 登录类型
 * @author zhangsan
 * @Date 2022/5/9 16:51
 */
public enum LoginType {

    PASSWORD(1),
    VALID_CODE(2);

    private Integer value;

    LoginType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
