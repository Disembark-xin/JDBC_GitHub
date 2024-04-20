package com.hualan.dao.impl;

import com.hualan.dao.UserDao;
import com.hualan.domain.Student;
import com.hualan.domain.User;
import com.hualan.utils.DaoUitls;
import com.hualan.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoImpl implements UserDao {
    @Override
    public User login(User user) throws SQLException {
        //1.获取连接对象
        Connection con = DruidUtils.getConnection();
        //2.写sql语句
        String sql = "select * from user where name = ? and password = ?";
        //3.获取预编译对象
        PreparedStatement ps = con.prepareStatement(sql);
        //4.给占位符赋值
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        //5.执行
        ResultSet rs = ps.executeQuery();
        User user1 = null;
        if(rs.next()){
            user1 = new User();
            user1.setId(rs.getInt("id"));
            user1.setName(rs.getString("name"));
            user1.setPassword(rs.getString("password"));
        }
        return user1;
    }

    @Override
    public int delById(int id) throws SQLException {
        Connection connection = DruidUtils.getConnection();
        String sql = "delete from stu where id = ?";
        int count = DaoUitls.test(connection,sql,2);
        System.out.println(count);

        connection.commit();//手动提交事务
        return count;
    }

    @Override
    public int updateUser(User user) throws SQLException {
        //1.获取连接
        Connection connection = DruidUtils.getConnection();
        //2.sql语句
        String sql = "update stu set name = ? where id = ?";
        int count = DaoUitls.test(connection,sql,"AAA",1);
        System.out.println(count);
        connection.commit();//手动提交事务
        return count;
    }

    @Override
    public int addStudent(Student student) throws SQLException, ParseException {
        //1.获取连接
        Connection connection = DruidUtils.getConnection();
        //2.sql语句
        String sql = "insert into stu values(null,?,?,?,?,?,?,?)";
//        java.sql.Date createTime = new java.sql.Date(student.getCreateTime().getTime());

        Date date = new Date();//获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        Date timestamp = simpleDateFormat.parse(format);

        System.out.println(timestamp);

        int count = DaoUitls.test(connection, sql, "李四", "男", 20, "郑州大学", "计算机科学与技术", "12345678945", timestamp);
        System.out.println(count);
        connection.commit();
        return count;
    }
}
