package com.zpark.gmd.project.dao;

import com.zpark.gmd.project.beans.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> seletAllEmp();

    public Integer deletEmpById(Integer id);

}
