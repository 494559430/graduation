<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/5/6
  Time: 9:58
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
    $.extend($.fn.validatebox.defaults.rules, {
        num: {
            validator: function(value, param){
                var reg = new RegExp("^[0-9]*[.]*[0-9]*$");
                return reg.test(value);
            },
            message: '请输入数字'
        }
    });

    $.ajax({
        type: "post",
        url: contextPath + "/supplier/getsupplier",
        dataType: "json",
        success: function (data) {
            for(var i in data){
                $("#supplierid")[0].innerHTML=$("#supplierid")[0].innerHTML+"<option value='"+data[i].supplierid+"'>"+data[i].suppliername+"</option>"
            }
        }
    })
    $.ajax({
        type: "post",
        url: contextPath + "/ShopItemTypeController/getshopitemtype",
        dataType: "json",
        success: function (data) {
            for(var i in data){
                $("#shopitemtype")[0].innerHTML=$("#shopitemtype")[0].innerHTML+"<option value='"+data[i].typeid+"'>"+data[i].typename+"</option>"
            }
        }
    })

</script>
<form id="supplier-form" method="post">

    <table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">
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
        <tr>
            <td>商品种类</td>
            <td><select id="shopitemtype" name="shopitemtype"></select></td>
        </tr>
        <tr>
            <td>是否上架</td>
            <td>
                <select id="ifgrounding" name="ifgrounding">
                    <option value="0">是</option>
                    <option value="1">否</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>供货商</td>
            <td>
                <select id="supplierid" name="supplierid">

                </select>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
