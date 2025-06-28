package com.zpark.gmd.project.servlet;
import com.zpark.gmd.project.beans.Employee;
import com.zpark.gmd.project.dao.impl.LoginDaolmpl;
import org.junit.Test;
public class TestMethod {
    @Test
    public void testLogin() {
        System.out.println("开始登录测试...");
        LoginDaolmpl loginDao = new LoginDaolmpl();
        Employee emp = loginDao.login("行秋", "123456");


    }
}