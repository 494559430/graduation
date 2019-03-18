<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
    <script src="${pageContext.request.contextPath}/js/list.js"></script>
</head>
<body>
<table id="dg"></table>

<div id="dg-toolbar">
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="eventobj.query()">查询</a>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="eventobj.add()">新增</a>
    <%--<a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="eventobj.update()">修改</a>--%>
    <%--<a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="eventobj.remove()">删除</a>--%>
</div>



<div id="emp-dialog">

</div>
</body>
</html>
