<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/5/8
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
    <script src="${pageContext.request.contextPath}/js/shop/shop.js"></script>
</head>
<body>
<table id="dg"></table>
<div id="dg-toolbar">
    商店编号：
    <input id="shopid" name="shopid" class="easyui-textbox" data-options="width:180" class="easyui-validatebox"  />
    商店名称：
    <input id="shopname" name="shopname" class="easyui-textbox" data-options="width:180" />
    商店地址：
    <input id="shopaddress" name="shopaddress" class="easyui-textbox" data-options="width:180" />
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="eventobj.query()">查询</a>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="eventobj.update()">修改</a>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="eventobj.add()">添加</a>
</div>
<div id="supplier-dialog">

</div>
</body>
</html>
