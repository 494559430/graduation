<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
    <script src="${pageContext.request.contextPath}/js/index.js"></script>

</head>

<style>
    a{
        text-decoration-line: none;
    }
</style>
<body>

<div  class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north'" style="height:100px;">
        <%--<div style="float: right;clear: both;line-height: 70px">--%>
        <%--<h3><span>欢迎：${emp.ename}</span><spna><a href="javascript:void(0)" onclick="logout();">退出</a></spna><span><a href="javascript:void(0)" onclick="editPass()">修改密码</a></span></h3>--%>
        <%--</div>--%>
    </div>
    <div data-options="region:'west',title:'导航'" style="width:250px;">
        <div id="aa" class="easyui-accordion" style="width:250px;height:300px;" data-options="fit:true,multiple:false">
            <div title="员工管理" data-options="iconCls:'icon-reload'" style="padding:10px;">
                <ul class="easyui-tree">
                    <%--<li><a class="opts" title="职位添加" url="/emp/toAddJob"><span style="display: block;width: 180px">部门管理</span></a></li>--%>
                    <li><a class="opts" title="员工管理" url="/emp/emp"><span style="display: block;width: 180px">员工管理</span></a></li>

                </ul>
            </div>
            <div title="供应商管理" data-options="iconCls:'icon-reload'" style="padding:10px;">
                <ul class="easyui-tree">
                    <li><a class="opts" title="部门管理" url="/turn/tolist"><span style="display: block;width: 180px">房间管理</span></a></li>
                    <li><a class="opts" title="员工出租" url="/turn/tolist2"><span style="display: block;width: 180px">房间出租</span></a></li>

                </ul>
            </div>



        </div>
    </div>
    <div data-options="region:'center'" style="padding:5px;">
        <div id="content" class="easyui-tabs" data-options="fit:true"></div>
    </div>
</div>
<div id="index-dialog">

</div>

</body>
</html>
