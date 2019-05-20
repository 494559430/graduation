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

    <link rel="shortcut icon" href="favicon.ico"> <link href="../css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="../css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="../css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css?v=4.1.0" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/shop/notice.js"></script>
</head>
<body>
<table id="dg"></table>
<div id="dg-toolbar">

    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="eventobj.query0()">未读消息</a>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="eventobj.query1()">已读消息</a>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="eventobj.query3()">警告消息</a>
    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="eventobj.delete()">删除</a>
</div>
<div id="notice-dialog">

</div>
<script src="../js/bootstrap.min.js?v=3.3.6"></script>



<!-- 自定义js -->
<script src="../js/content.js?v=1.0.0"></script>


<!-- iCheck -->
<script src="../js/plugins/iCheck/icheck.min.js"></script>

<!-- SUMMERNOTE -->
<script src="../js/plugins/summernote/summernote.min.js"></script>
<script src="../js/plugins/summernote/summernote-zh-CN.js"></script>
</body>
</html>
