package com.unfair.bootstrap.base;

import java.util.List;

public interface BaseService<T,E> {

    public List<T> queryEntry(E e);
}
