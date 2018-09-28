package com.how2java.springboot.dateSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2018/9/12 0012.
 */
public class JdbcUtil {
    //创建pool
    private static JdbcPool jdbcPool = new JdbcPool();

    //得到连接
    public static Connection getConnection() throws SQLException {
        return jdbcPool.getConnection();
    }

    public static void release(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try{
                //关闭Connection数据库连接对象
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

