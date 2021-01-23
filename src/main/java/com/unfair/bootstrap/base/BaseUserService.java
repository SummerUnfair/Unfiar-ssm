package com.unfair.bootstrap.base;

import java.util.List;

/**
 * @author fenghao
 * @discription
 * @create 2021-01-23 14:03
 */
public interface BaseUserService<T, E> extends BaseService {
    /**
     * 查询单个用户
     *
     * @param request
     * @return
     */
    public BaseResponse queryEntry(BaseRequest request);
}
