<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/5/8
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
        },
        mobile: {
            validator: function (value, param) {
                return /^(?:13\d|15\d|18\d)-?\d{5}(\d{3}|\*{3})$/.test(value);
            },
            message: '手机号码不正确'
        },
        idCode:{
            validator:function(value,param){
                return /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(value);
            },
            message: '请输入正确的身份证号'
        }
    });
</script>
    <form id="supplier-form" method="post">
        <table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">

            <tr>
                <td>商店名称</td>
                <td><input class="easyui-validatebox" id="shopname" name="shopname" value="${shop.shopname}" data-options="required:true,width:180,validType:'length[1,20]'"></td>
            </tr>
            <tr>
                <td>商店地址</td>
                <td>
                    <input class="easyui-validatebox" id="shopaddress" name="shopaddress" value="${shop.shopaddress}" data-options="required:true,width:180,validType:'length[1,100]'">
                </td>
            </tr>
            <tr>
                <td>商店负责人</td>
                <td>
                    <input class="easyui-validatebox" id="shopperson" name="shopperson" value="${shop.shopperson}" data-options="required:true,width:180,validType:'length[1,10]'">
                </td>
            </tr>
            <tr>
                <td>联系方式</td>
                <td>
                    <input class="easyui-validatebox" id="shopphone" name="shopphone" value="${shop.shopphone}" data-options="required:true,width:180,validType:'mobile'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
