<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    #background{
        background-image: url(${pageContext.request.contextPath}/css/background.png);
        background-size: 100% 150px;
    }
</style>
<body>

<div  class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north'" id="background" style="height:150px;">

    </div>
    <div data-options="region:'west',title:'导航'" style="width:250px;">
        <div id="aa" class="easyui-accordion" style="width:250px;height:300px;" data-options="fit:true,multiple:false">
            <div title="员工管理" data-options="iconCls:'icon-reload'" style="padding:10px;">
                <ul class="easyui-tree">
                    <%--<li><a class="opts" title="职位添加" url="/emp/toAddJob"><span style="display: block;width: 180px">部门管理</span></a></li>--%>
                    <li><a class="opts" title="员工管理" url="/emp/emp"><span style="display: block;width: 180px">员工管理</span></a></li>

                </ul>
            </div>
            <div title="商品管理" data-options="iconCls:'icon-reload'" style="padding:10px;">
                <ul class="easyui-tree">
                    <li><a class="opts" title="商品管理" url="/turn/toshopItem"><span style="display: block;width: 180px">商品管理</span></a></li>
                   <%-- <li><a class="opts" title="添加商品" url="/turn/toshopItemAdd"><span style="display: block;width: 180px">添加商品</span></a></li>--%>
                    <li><a class="opts" title="商品种类" url="/turn/toshopItemType"><span style="display: block;width: 180px">商品种类</span></a></li>
                    <li><a class="opts" title="销售统计" url="/turn/tosalebill"><span style="display: block;width: 180px">销售统计</span></a></li>
                </ul>
            </div>

            <div title="供应商管理" data-options="iconCls:'icon-reload'" style="padding:10px;">
                <ul class="easyui-tree">
                    <li><a class="opts" title="供应商查看" url="/supplier/supplier"><span style="display: block;width: 180px">供应商查看</span></a></li>
                </ul>
            </div>
            <c:if test="${user.shopId==1}">
            <div title="连锁店管理" data-options="iconCls:'icon-reload'" style="padding:10px;">
                <ul class="easyui-tree">
                    <li><a class="opts" title="连锁店管理" url="/turn/toshop"><span style="display: block;width: 180px">连锁店管理</span></a></li>
                    <li><a class="opts" title="通知发放" url="/turn/toNotice"><span style="display: block;width: 180px">通知发放</span></a></li>
                </ul>
            </div>
            </c:if>

        </div>
    </div>
    <div data-options="region:'center'" style="padding:5px;">
        <div id="content" class="easyui-tabs" data-options="fit:true">
        </div>
    </div>
    <div data-options="region:'south'" style="padding:2px;">
            <span>欢迎,${user.username}</span><spna>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="logout();">退出</a></spna>
        <span style="align:right">&nbsp;&nbsp;&nbsp;&nbsp;你还有${unread}条<a class="opts" title="通知" url="/turn/notice">通知</a>未读</span>
    <script>
        function logout() {
            window.location.replace(contextPath+"/user/logout");
        }
    </script>
    </div>
</div>
<div id="index-dialog">

</div>

</body>
</html>
