<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/5/4
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
</head>
<body>
    <table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">
        <tr>
            <td>商品编号</td>
            <td>${shopitemdescrip.shopitemid}</td>
        </tr>
        <tr>
            <td>商品名称</td>
            <td>${shopitemdescrip.shopitemname}</td>
        </tr>
        <tr>
            <td>商品价格（元）</td>
            <td>${shopitemdescrip.price}</td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td>${shopitemdescrip.descrip}</td>
        </tr>

    </table>
</body>
</html>
