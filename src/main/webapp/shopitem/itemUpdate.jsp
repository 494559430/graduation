<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/5/5
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <%@include file="/easyui/include.jsp"%>
</head>
<body>
<script>
    $.extend($.fn.validatebox.defaults.rules, {
        num: {
            validator: function(value, param){
                var reg = new RegExp("^[0-9]*[.]*[0-9]*$");
                return reg.test(value);
            },
            message: '请输入数字'
        }
    });
</script>
<form id="supplier-form" method="post">
    <table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">
        <tr>
            <td>商品编号</td>
            <td>${shopitemdescrip.shopitemid}</td>
        </tr>
        <input style="display: none" type="text" id="shopid" name="shopid" value="${shopitemdescrip.shopid}">
        <c:if test="${user.shopId==1}">
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

            <tr style="display: none">
                <td>供应商</td>
                <td>
                    <input  name="supplierid" id="supplierid" value="${shopitemdescrip.supplierid}" />
                </td>
            </tr>
        </c:if>
        <c:if test="${user.shopId!=1}">
            <tr>
                <td>商品名称</td>
                <td>${shopitemdescrip.shopitemname}</td>
            </tr>
            <tr>
                <td>商品价格（元）</td>
                <td> ${shopitemdescrip.price}</td>
            </tr>
            <tr>
                <td>商品描述</td>
                <td>
                    ${shopitemdescrip.descrip}
                </td>
            </tr>

        </c:if>
        <tr>
            <td>商品库存</td>
            <td>
                <input class="easyui-validatebox" name="num" id="num" value="${shopitemdescrip.num}" data-options="required:true,validType:'num'"/>
            </td>
        </tr>
        <tr>
            <td>是否上架</td>
            <td>
                <select id="ifgrounding" name="ifgrounding" >
                    <option value="0">是</option>
                    <option value="1">否</option>
                </select>
                    <input type="hidden" value="${shopitemdescrip.ifgrounding}" id="up"/>
            </td>
            <script>
                $(document).ready(function(){
                    var x = document.getElementById("up").value;
                    $("#ifgrounding").val(x);
                });
            </script>

        </tr>
    </table>
</form>
</body>
</html>
