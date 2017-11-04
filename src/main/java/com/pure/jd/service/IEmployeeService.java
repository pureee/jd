package com.pure.jd.service;

import com.pure.jd.entity.Employee;

import java.util.List;

/**
 * Created by pure on 2017/6/16.
 */
public interface IEmployeeService {

    void save(Employee employee);

    void update(Employee employee);

    Employee get(long id);

    void delete(long id);

    List<Employee> listAll();

}
