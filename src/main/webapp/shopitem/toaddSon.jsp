<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/5/6
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
</head>
<body>
<script>
    $.ajax({
        type: "post",
        url: contextPath + "/ShopItemTypeController/getshopitemtypeParent",
        dataType: "json",
        success: function (data) {
            for(var i in data){
                $("#parentid")[0].innerHTML=$("#parentid")[0].innerHTML+"<option value='"+data[i].typeid+"'>"+data[i].typename+"</option>"
            }
        }
    })
</script>
<form id="supplier-form" method="post">
    <table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">
        <tr>
            <td>父类名称</td>
            <td><select id="parentid" name="parentid"></select></td>
        </tr>
        <tr>
            <td>种类名称</td>
            <td>
                <input type="text" id="typename" name="typename">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
