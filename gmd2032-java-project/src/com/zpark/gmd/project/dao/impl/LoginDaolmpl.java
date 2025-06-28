package com.zpark.gmd.project.dao.impl;

import com.zpark.gmd.project.utils.JDBCUtil;
import com.zpark.gmd.project.beans.Employee;
import com.zpark.gmd.project.dao.LoginDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginDaolmpl implements LoginDao {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        @Override
        public Employee login(String name, String password) {
                conn =JDBCUtil.getConn();
                String sql = "select * from employee where name=? and password=?";
                Employee employee = null;
                try {
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, name);
                        pst.setString(2, password);
                        rs = pst.executeQuery();
                        while (rs.next()) {
                                employee = new Employee();
                                employee.setId(rs.getInt("id"));
                                employee.setName(rs.getString("name"));
                                employee.setPassword(rs.getString("password"));
                                employee.setGender(rs.getString("gender"));
                                employee.setSalary(rs.getInt("salary"));
                                employee.setJoinDate(rs.getDate("join_date"));
                                employee.setDeptId(rs.getInt("dept_id"));
                        }
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
                return employee;
        }
        }