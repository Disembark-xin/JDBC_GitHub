package com.hualan.servlet;

import com.hualan.dao.UserDao;
import com.hualan.dao.impl.UserDaoImpl;
import com.hualan.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String name = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        //可以把获取的参数封装成User对象
        User user = new User(name, pwd);
        HttpSession session = req.getSession();
        //把User对象 作为参数 取数据库查询 完成登录操作
        UserDao dao = new UserDaoImpl();
        try {
            User userDao = dao.login(user);
            //判断userDao是否为空
            if(userDao == null){
            session.setAttribute("msg","用户名或密码错误");
            resp.sendRedirect("/login.jsp");
            }else{
                session.setAttribute("user",user);
                resp.sendRedirect("/main.jsp");
            }
        } catch (SQLException e) {
            System.out.println("登录失败！");
        }
    }
    }
