package com.realguo.common.utils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 构造模糊查询帮助类
 *
 * @param <T>
 */

public class MyEntityWrapper<T> extends EntityWrapper<T> {
    private static final long serialVersionUID = 1L;

    /**
     * 构造模糊查询
     */
    public MyEntityWrapper(Map<String, Object> map) {
        Map<String, Object> newMap = Maps.newHashMap(map);
        newMap.remove("page");
        newMap.remove("limit");
        newMap.remove("sort");
        newMap.forEach((key, val) -> {
            this.like(key, (String) val);
        });
    }
}
