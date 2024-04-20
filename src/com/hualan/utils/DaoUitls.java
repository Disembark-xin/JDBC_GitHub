package com.hualan.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoUitls {
    /**
     * 封装一个通用的增删改方法   半封装
     * insert into t_stu values(?,?,?)
     * test(con,)
     */
    public static int test(Connection con,String sql,Object...args) throws SQLException {
        PreparedStatement ps = con.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1,args[i]);
        }
       return ps.executeUpdate();
    }

}