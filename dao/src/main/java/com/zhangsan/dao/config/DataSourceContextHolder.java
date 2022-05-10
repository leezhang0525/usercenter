package com.zhangsan.dao.config;


import com.zhangsan.common.enums.DataSourceType;

/**
 * 数据源处理器
 */
public class DataSourceContextHolder {

    private DataSourceContextHolder(){}

    private static final ThreadLocal<String>  holder = new ThreadLocal<>();

    public static void putDataSource(DataSourceType dataSourceType) {
        holder.set(dataSourceType.getValue());
    }

    public static String getDataSource() {
        return holder.get();
    }

    public static void clearDataSource() {
        holder.remove();
    }

}
