package com.how2java.springboot.dateSource;


import javax.sql.DataSource;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/9/12 0012.
 */
//需要实现DataSource
public class JdbcPool implements DataSource{
    //使用connectionList存放连接，因为要频繁读写，用linkedlist比较合适
    private static LinkedList<Connection> connectionList = new LinkedList<>();
    static{
        //获得JdbcPool类的类加载器,加载db.properties数据库配置文件
        InputStream properties = JdbcPool.class.getClassLoader().getResourceAsStream("db.properties");
        Properties prop = new Properties();
        try{
            prop.load(properties);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            //初始化连接池的大小
            int jdbcPoolInitSize = Integer.parseInt(prop.getProperty("size"));
            //加载驱动程序
            Class.forName(driver);
            //建立连接
            for(int i = 0; i < jdbcPoolInitSize; i++){
                Connection con = DriverManager.getConnection(url,username,password);
                System.out.println("获取了连接" + i);
                //将连接存入connectionList
                connectionList.add(con);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }

    }
    @Override
    public Connection getConnection() throws SQLException {
        if(connectionList.size() > 0){
           final Connection conn = connectionList.removeFirst();
            System.out.println("listConnections数据库连接池大小是" + connectionList.size());
            //返回被Connection的代理对象
            return (Connection) Proxy.newProxyInstance(this.getClass().getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                //当close方法被调用时将conn还回池中,其它方法直接执行
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (!method.getName().equals("close")) {
                       return method.invoke(conn, args);
                    } else{
                        //如果调用的是Connection对象的close方法，就把conn还给数据库连接池
                        connectionList.add(conn);
                        System.out.println(conn + "被还给listConnections数据库连接池了！！");
                        System.out.println("listConnections数据库连接池大小为" + connectionList.size());
                        return null;
                    }
                }
            });
        }else{
            throw new RuntimeException("服务器繁忙");
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
