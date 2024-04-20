package com.hualan.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 德鲁伊连接池工具类
 */
public class DruidUtils {
    static DataSource dataSource = null;
    static {
        try {
            // 通过 类加载器 把 jdbc.properties的配置信息 读取到了 输入流中
            InputStream in = DruidUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 创建Map集合
            Properties properties = new Properties();
            // 把流中的信息 存储到Map集合中
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        Connection con = null;
        try {
            con = dataSource.getConnection();

            con.setAutoCommit(false);//设置事务手动提交 默认的话为自动提交，每当执行一个update ,delete或者insert的时候都会自动提交到数据库，无法回滚事务。

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    /**
     * 释放连接的方法
     */
    public static void closeAll(Connection con, PreparedStatement ps, ResultSet rs){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("关闭连接异常");
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("ps执行对象关闭异常");
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("结果集关闭异常");
            }
        }
    }


}

