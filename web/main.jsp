<%--
  Created by IntelliJ IDEA.
  User: YHP05
  Date: 2024/4/8
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
<%--    Object userName = session.getAttribute("userName");--%>
<%--    if(userName == null){--%>
<%--        session.setAttribute("msg","没有登录，请登录");--%>
<%--        response.sendRedirect("login.jsp");--%>
<%--    }--%>
<%--%>--%>
<h3>欢迎${user.name}登录XXXX系统</h3>
<form action="/logout" method="get" >
    <input type="submit" value="退出">
</form>

<a href="/testServlet?action=del&id=2">删除id为2的用户</a>
<a href="/testServlet?action=update&id=1&userName=AAA">修改id为1的用户</a>
<a href="/testServlet?action=add&name=李四&sex=男&age=25&college=郑州大学&major=计算机机科学与技术&phone=123456">添加用户</a>
</body>
</html>
