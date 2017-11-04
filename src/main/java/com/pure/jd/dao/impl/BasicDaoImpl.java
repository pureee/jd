package com.pure.jd.dao.impl;

import com.pure.jd.dao.IBasicDao;

import javax.persistence.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by pure on 2017/6/16.
 */
public class BasicDaoImpl<T> implements IBasicDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> clazz;

    private String clazzName;

    protected BasicDaoImpl() {
        Type clazzType = this.getClass().getGenericSuperclass();//获取泛型的直接父类
        if (clazzType instanceof ParameterizedType) {//如果该类型是参数化类型,如 Collection<String>,即当前泛型
            Type[] actualTypeArguments = ((ParameterizedType) clazzType).getActualTypeArguments();//获取实际参数类型
            clazz = (Class<T>) actualTypeArguments[0];//目前只有一个泛型,所以取第0个泛型代表的对象
            clazzName = clazz.getSimpleName();
        }
    }

    public void saveOrUpdate(T entity) {
        update(entity);
    }

    public void save(T entity) {
        if (entity != null) {
            entityManager.persist(entity);
        }
    }

    public void update(T entity) {
        if (entity != null) {
            entityManager.merge(entity);
        }
    }

    public T get(long id) {
        if (id > 0) {
            return entityManager.find(clazz, id);
        }
        return null;
    }

    public void delete(long id) {
        if (id > 0) {
            entityManager.remove(entityManager.find(clazz, id));
        }
    }

    public List<T> listAll() {
        String sql = "SELECT obj FROM " + clazzName + " obj ";
        Query query = entityManager.createQuery(sql);
        List<T> resultList = query.getResultList();
        return resultList;
    }


}

