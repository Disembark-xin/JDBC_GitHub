package com.hualan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

//        System.out.println(session.getAttribute("userName"));
//        System.out.println(session.getAttribute("password"));
//        session.setMaxInactiveInterval(1);
        //手动销毁session
        session.invalidate();
        resp.sendRedirect("/login.jsp");
//        System.out.println(session.getAttribute("username"+"---------------"));
//        System.out.println(session.getAttribute("password"+"---------------"));
    }
}
