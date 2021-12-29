<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="http://www.htmleaf.com/js/jquery/1.4.4/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户</title>
    <script type="text/javascript">
        function del(id){
            $.get("/delUser?id=" + id,function(data){
                if("success" == data.result){
                    alert("删除成功");
                    window.location.reload();
                }else{
                    alert("删除失败");
                }
            });
        }
    </script>
</head>
<body>

<h3><a href="">漫画用户关注</a></h3>
<table border="1">
    <tbody>
    <tr>
        <th>漫画名称</th>
        <th>图片</th>
        <th>类型</th>
        <th>操作</th>
    </tr>
    <c:if test="${!empty mangaList}">
        <c:forEach items="${mangaList}" var="manga">
            <tr>
                <td>${manga.nom }</td>
                <td>${manga.photo }</td>
                <td>${manga.type }</td>
                <td>
                    <c:if test="${manga.status == 0 || manga.status == null}">
                        <a href="followManga?id=${manga.id }">关注</a>
                    </c:if>
                    <c:if test="${manga.status == 1}">
                        已关注
                    </c:if>
                    <%--<a href="javascript:del('${user.id}')">删除</a>--%>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>