package com.zhangsan.web.interceptor;

import java.util.List;

/**
 * @author zhangsan
 * @Date 2022/5/10 11:54
 */
public interface ExcludePath {
    /**
     * 拦截器路径
     * @return
     */
    List<String> getExcludePath();
}
