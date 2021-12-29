<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录系统</title>
</head>
<body>
<h1 align="center">请使用账户登录</h1>
<hr style="height: 5px">
<div style="margin-top: 100px" align="center">
    <form action="login" method="post">
        <table align="center" style="border-style: double; width: 300px; height: 200px;">
            <tr>
                <td>账号:</td>
                <td><input id="userName" name="userName" type="text"/>

                </td>
            </tr>
            <tr><td colspan="2" align="center"><span>${idmsg}</span></td></tr>
            <tr>
                <td>密码:</td>
                <td><input id="passWord" name="passWord" type="password" /></td>
            </tr>
            <tr><td colspan="2" align="center"><span>${pwdmsg}</span></td></tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>