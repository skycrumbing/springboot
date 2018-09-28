package com.how2java.springboot.dateSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/12 0012.
 */
public class test {
    public static void main(String args[]) throws SQLException {
        List<Connection> list = new ArrayList<>();
       for(int i = 0; i < 11; i++){
           list.add(JdbcUtil.getConnection());
       }
    }
}
