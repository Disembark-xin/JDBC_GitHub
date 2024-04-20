package com.hualan.dao;

import com.hualan.domain.Student;
import com.hualan.domain.User;

import java.sql.SQLException;
import java.text.ParseException;

public interface UserDao {
    //登录
    User login(User user) throws SQLException;
    //根据id删除
    int delById(int id) throws SQLException;
    //修改
    int updateUser(User user) throws SQLException;
    //添加信息
    int addStudent(Student student) throws SQLException, ParseException;
}
