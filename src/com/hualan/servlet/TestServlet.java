package com.hualan.servlet;

import com.hualan.dao.impl.UserDaoImpl;
import com.hualan.domain.Student;
import com.hualan.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("del".equals(action)){
            //执行删除
            try {
                delUser(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else if("update".equals(action)){
            //执行修改
            try {
                updateUser(req,resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else if("add".equals(action)){
            try {
                addStudent(req,resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ParseException {
        String name = req.getParameter("userName");
        String sex = req.getParameter("sex");
        int age = Integer.parseInt(req.getParameter("age"));
        String college = req.getParameter("college");
        String major = req.getParameter("major");
        String phone = req.getParameter("phone");

//        Date create_time = new Date(req.getParameter("create_time"));

        UserDaoImpl dao = new UserDaoImpl();
        int i = dao.addStudent(new Student(name, sex, age, college, major, phone));
        if (i > 0) {
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }


    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String userName = req.getParameter("userName");
        UserDaoImpl dao = new UserDaoImpl();
        int i = dao.updateUser(new User(id, userName));
        if( i > 0 ){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }


    }

    private void delUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        //删除  获取删除的id
        int id = Integer.parseInt(req.getParameter("id"));
        UserDaoImpl dao = new UserDaoImpl();
        int i = dao.delById(id);
        if(i>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }


}
