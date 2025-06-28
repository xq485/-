import com.zpark.gmd.project.beans.Employee;
import com.zpark.gmd.project.service.LoginService;
import com.zpark.gmd.project.service.imol.LoginServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LoginService loginService = new LoginServiceImp();
        //解决中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 修正：使用实例调用方法
        Employee emp = loginService.login(username, password);

        //判断 emp 对象为空 登录失败
        if(emp != null){
            req.getSession().setAttribute("emp",emp);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }else{
            String msg = "登录名或密码错误";
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}