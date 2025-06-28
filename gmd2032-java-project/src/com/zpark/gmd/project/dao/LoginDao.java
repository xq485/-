package com.zpark.gmd.project.dao;

import com.zpark.gmd.project.beans.Employee;

public interface LoginDao {
    //1.持久层的登录方法
    public Employee login(String name,String password);
}
