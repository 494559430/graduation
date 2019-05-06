<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/5/5
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%@include file="/easyui/include.jsp"%>
</head>
<body>
<form id="supplier-form" method="post">
    <table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">
        <tr>
            <td>商品编号</td>
            <td>${shopitemdescrip.shopitemid}</td>
        </tr>
        <tr>
            <td>商品名称</td>
            <td><input class="easyui-validatebox"  id="shopitemname" name="shopitemname" data-options="required:true,validType:'length[1,20]'" value="${shopitemdescrip.shopitemname}"></td>
        </tr>
        <tr>
            <td>商品价格（元）</td>
           <td> <input class="easyui-validatebox" id="price" name="price" value="${shopitemdescrip.price}" data-options="required:true,validType:'num'"></td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td>
                <textarea class="easyui-validatebox" name="descrip" id="descrip" cols="30" rows="10"  >${shopitemdescrip.descrip}</textarea>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
