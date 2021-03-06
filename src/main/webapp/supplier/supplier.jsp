<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
    <script src="${pageContext.request.contextPath}/js/supplier/list.js"></script>
</head>
<body>
<table id="dg"></table>

<div id="dg-toolbar">
    供应商姓名：
    <input id="suppliername" name="suppliername" class="easyui-textbox" data-options="width:180" />
    负责人姓名：
    <input id="representative" name="representative" class="easyui-textbox" data-options="width:180" />
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="eventobj.query()">查询</a>
    <c:if test="${user.shopId==1}">
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="eventobj.add()">新增供应商</a>
    </c:if>
    <c:if test="${user.shopId==1}">
        <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="eventobj.update()">修改供应商</a>
    </c:if>
    <%--<a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="eventobj.remove()">删除</a>--%>
</div>



<div id="supplier-dialog">

</div>
</body>
</html>
