package com.pure.jd.dao;

import com.pure.jd.entity.Employee;

import java.util.List;

/**
 * Created by pure on 2017/6/16.
 */
public interface IBasicDao<T> {

    void save(T entity);

    void update(T entity);

    void saveOrUpdate(T entity);

    T get(long id);

    void delete(long id);

    List<T> listAll();

}
