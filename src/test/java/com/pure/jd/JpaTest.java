//package com.pure.jd;
//
//
//import com.pure.jd.entity.Employee;
//import com.pure.jd.utils.EntityManagerUtil;
//import org.jboss.logging.Logger;
//import org.junit.Test;
//
//import javax.persistence.EntityManager;
//import javax.transaction.TransactionManager;
//
///**
// * Created by pure on 2017/6/15.
// */
//public class JpaTest {
//
//    final Logger logger = Logger.getLogger(Employee.class);
//    private TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
//    private EntityManager manager = null;
//
//    @Test
//    public void jpaSaveTest() {
//        try {
//            manager = EntityManagerUtil.getEntityManager();
//            Employee emp = new Employee();
//            emp.setLoginName("hejd");
//            emp.setName("pure");
//            emp.setPassword("123456");
//            logger.info("......");
//            tm.begin();
//            manager.persist(emp);
//            tm.commit();
//
//            Employee employee = manager.find(Employee.class, emp.getId());
//            logger.info(employee.toString());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (manager != null) {
//                manager.close();
//            }
//        }
//
//    }
//
//    @Test
//    public void jpaUpdateTest() {
//        manager = EntityManagerUtil.getEntityManager();
//        Employee employee = manager.find(Employee.class, 2l);
//        employee.setName("hejunda1");
//        try {
//            tm.begin();
//            manager.merge(employee);
//            tm.commit();
//            logger.info("更新对象:" + manager.find(Employee.class, 2l));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (manager != null) manager.close();
//        }
//
//    }
//
//    @Test
//    public void jpaDeleteTest(){
//        manager = EntityManagerUtil.getEntityManager();
//        Employee employee = manager.find(Employee.class, 2l);
//        try {
//            tm.begin();
//            manager.remove(employee);
//            tm.commit();
//            logger.info("更新对象:" + manager.find(Employee.class, 2l));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (manager != null) manager.close();
//        }
//    }
//
//
//    @Test
//    public void test(){
////        try{
////            int i = 1/0;
//            System.out.println(1234);
////        }catch (Exception e){
////            System.out.println("getMsg:"+e.getMessage());
////            System.out.println("getCause:"+e.getCause());
////            System.out.println("getLocalMsg:"+e.getLocalizedMessage());
////            e.printStackTrace();
////        }finally{
////            System.out.println("finally");
////        }
////        System.out.println("程序还是继续运行");
//
//    }
//
//}
