package com.pure.jd.service.impl;

import com.pure.jd.dao.IEmployeeDao;
import com.pure.jd.entity.Employee;
import com.pure.jd.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pure on 2017/6/16.
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;

     public void save(Employee employee) {
        employeeDao.save(employee);
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    public Employee get(long id) {
        return employeeDao.get(id);
    }

    public void delete(long id) {
        employeeDao.delete(id);
    }

    public List<Employee> listAll() {
        return employeeDao.listAll();
    }

}
