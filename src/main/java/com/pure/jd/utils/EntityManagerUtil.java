package com.pure.jd.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by pure on 2017/6/16.
 */
public final class EntityManagerUtil {

    private static EntityManagerFactory emf = null;
    private static EntityManager manager = null;

    private EntityManagerUtil() {

    }

    static {
        emf = Persistence.createEntityManagerFactory("persistenceUnit");
        manager = emf.createEntityManager();
    }

    public static EntityManager getEntityManager(){
        return manager;
    }



}
