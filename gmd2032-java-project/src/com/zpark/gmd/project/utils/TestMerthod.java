package com.zpark.gmd.project.utils;
import java.sql.Connection;
public class TestMerthod {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.getConn();
        System.out.println(conn != null?"链接数据库成功！":"链接数据库失败！");
        JDBCUtil.closeAll(conn,null,null);
    }
}