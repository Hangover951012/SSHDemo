<%@ page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>查询</title>
    <style>
        body {
            background: url(img/aa.jpeg) center;
            background-size: cover;
        }
    </style>
</head>
<body><%--设置背景图片--%>
</br></br></br>
<form action="getAllManga" method="POST">
    <input type="hidden" id="${user.id}" name="${user.id}">
    <input type="hidden" id="${user.userName}" name="${user.userName}">
    <table align="center">
        <h1 style="text-align:center;font-size:50px">漫画检索</h1>
        <tr>
            <td id="tm1">
                <a title="按英文查询" href="followMangaList">漫画收藏夹</a> &nbsp;
            </td>
            <%--<td id="tm2">--%>
                <%--<a title="按中文查询" href="http://localhost:8080/h2.jsp">按中文查询</a> &nbsp;--%>
            <%--</td>--%>
            <%--<td id="tm3">--%>
                <%--<a title="按词性查询" href="http://localhost:8080/h3.jsp">按词性查询</a> &nbsp;--%>
            <%--</td>--%>
            <%--<td id="tm4">--%>
                <%--<a title="按难度查询" href="http://localhost:8080/h4.jsp">按难度查询</a>--%>
            <%--</td>--%>
        </tr>
    </table>
    <table align="center">
        <tr>
            </br>
            <td><input type="text" name="nom" id="nom" size="30" placeholder="请输入漫画名进行搜索"></td>
            <th><input type="submit" value="搜索"></th>
        </tr>
    </table>
</form>
<%--<form action="count.jsp" method="POST">--%>
    <%--<table align="center">--%>
        <%--<tr>--%>
            <%--</br></br>--%>
            <%--<td><input type="submit" value=" 统计首字母开头单词个数（A-Z）"></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form>    --%>
</body>
</html>