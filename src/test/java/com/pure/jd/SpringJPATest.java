//package com.pure.jd;
//
//import com.pure.jd.batch.BatchService;
//import com.pure.jd.dao.IUserDao;
//import com.pure.jd.entity.Employee;
//import com.pure.jd.service.IEmployeeService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by pure on 2017/6/16.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//public class SpringJPATest {
//
//    @Autowired
//    private IUserDao userDao;
//    @Autowired
//    private IEmployeeService service;
//
//    @Test
//    public void userTest(){
//        boolean b = userDao.checkPhoneExsit("123456789013");
//        System.out.println(b);
//    }
//
//
//    @Test
//    public void springJpaSaveTest(){
//        Employee employee = new Employee();
//        employee.setName("dfsdffff");
//        service.save(employee);
//    }
//
//    @Test
//    public void springJpaUpdateTest(){
//        Employee employee = service.get(5);
//        employee.setPassword("12345hhh345");
//        service.update(employee);
//    }
//
//    @Test
//    public void springJpaListTest(){
//
//        List<Employee> employees = service.listAll();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
//    }
//
//    @Autowired
//    private BatchService batchService;
//
//    @Test
//    public void springJpaBatchInsertTest(){
//        List<Employee> es = new ArrayList<Employee>();
//        for (int i = 0; i < 100; i++) {
//            Employee employee = new Employee();
//            employee.setName("employee:"+(i+1));
//
//            es.add(employee);
//        }
//        batchService.batchInsert(es);
//    }
//
//    @Test
//    public void springJpaBatchDeleteTest(){
//        List<Long> es = new ArrayList<Long>();
//        for (long i = 1; i <= 100; i++) {
//            es.add(i);
//        }
//        batchService.batchDelete(es);
//    }
//
//
//
//}
