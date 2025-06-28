package com.zpark.gmd.project.service;

import com.zpark.gmd.project.beans.Employee;

public interface LoginService {
    Employee login(String name, String password);
}