package com.zpark.gmd.project.servlet;
import com.zpark.gmd.project.beans.Employee;
import com.zpark.gmd.project.utils.JDBCUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@WebServlet("/emp/*")
public class EmployeeServlet extends HttpServlet {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求资源路径，区分不同功能！
        String requestURI = req.getRequestURI();
        //2、获取最后一个“/”的下标
        int beginIndex = requestURI.lastIndexOf("/");
        //3、截取子字符串
        String servletPath = requestURI.substring(beginIndex);
        //System.out.println(servletPath);
        //4、根据不同的请求资源路径，完成不同的业务逻辑
        if(servletPath.equals("/findAllEmp")){
            //4.7、创建员工对象
            Employee employee = null;
            //4.6、创建保存对象的list集合
            ArrayList<Employee> list = new ArrayList<>();
            //4.1、获取链接对象
            conn = JDBCUtil.getConn();
            //4.2、定义SQL语句
            String sql = "select * from employee";
            try {
                //4.3、获取执行SQL语句的对象
                pstmt = conn.prepareStatement(sql);
                //4.4、执行SQL语句，返回结果集
                rs = pstmt.executeQuery();
                //4.5、遍历结果集
                while(rs.next()){
                    employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("name"));
                    employee.setGender(rs.getString("gender"));
                    employee.setSalary(rs.getInt("salary"));
                    employee.setJoinDate(rs.getDate("join_date"));
                    employee.setDeptId(rs.getInt("dept_id"));
                    employee.setPassword(rs.getString("password"));
                    list.add(employee);
                }
                //4.6、绑定数据
                req.setAttribute("list", list);
                //4.7、请求转发jsp页面
                req.getRequestDispatcher("/list.jsp").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                //5、关闭资源对象
                JDBCUtil.closeAll(conn, pstmt, rs);
            }
        }
    }
}
