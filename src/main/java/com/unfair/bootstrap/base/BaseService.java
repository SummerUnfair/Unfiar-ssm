package com.unfair.bootstrap.base;

import java.util.List;

public interface BaseService<T,E> {

    public List<T> queryEntry_original(E e);

    public BaseResponse queryEntry(BaseRequest request);
}
