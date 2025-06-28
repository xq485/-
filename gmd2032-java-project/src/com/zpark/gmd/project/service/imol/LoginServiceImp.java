package com.zpark.gmd.project.service.imol;

import com.zpark.gmd.project.beans.Employee;
import com.zpark.gmd.project.dao.LoginDao;
import com.zpark.gmd.project.dao.impl.LoginDaolmpl;
import com.zpark.gmd.project.service.LoginService;

public class LoginServiceImp implements LoginService{
    private LoginDao dao = new LoginDaolmpl();

    @Override
    public Employee login(String name, String password) {
        // 调用 DAO 层的登录方法，可在这里扩展业务逻辑（如参数校验、日志记录等）
        return dao.login(name, password);
    }
}

