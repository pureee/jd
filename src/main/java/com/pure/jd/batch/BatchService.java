package com.pure.jd.batch;

import com.pure.jd.entity.Employee;
import com.pure.jd.utils.EntityManagerUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by pure on 2017/6/17.
 * 批量删除业务处理
 */
@Service
public class BatchService {

    private final int batchSize = 30;

    public void batchInsert(List<Employee> entityList) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        for (int i = 0; i < entityList.size(); i++) {
            entityManager.persist(entityList.get(i));
            if (i % batchSize == 0) {
                flushCacheAndCommitTransaction(entityManager, transaction);
            }
        }
        flushCacheAndCommitTransaction(entityManager, transaction);
    }

    /**
     * 将entityManager中的数据刷入数据库，并清空Session缓存
     *
     * @param entityManager
     * @param transaction
     */
    private void flushCacheAndCommitTransaction(EntityManager entityManager, EntityTransaction transaction) {
        entityManager.flush();
        entityManager.clear();
        transaction.commit();
        transaction.begin();
    }


    public void batchDelete(List<Long> ids) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        for (int i = 0; i < ids.size(); i++) {
            entityManager.remove(entityManager.find(Employee.class, ids.get(i)));
            if (i % batchSize == 0) {
                //将entityManager中的数据刷入数据库，并清空Session缓存
                flushCacheAndCommitTransaction(entityManager, transaction);
            }
        }
        flushCacheAndCommitTransaction(entityManager, transaction);
    }

}
