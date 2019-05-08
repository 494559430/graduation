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
    <div data-options="region:'north'" style="height:150px;">
        <div class="navbar-header" style="padding-top:1px;padding-bottom:10px;height:20px;width:100%;background-color:rgb(149, 184, 231)">
        <h3 style="align:right;"><span>欢迎,第${user.shopId}分店管理员${user.username}</span><spna><a href="javascript:void(0)" onclick="logout();">退出</a></spna></h3>
      </div>
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


                </ul>
            </div>
            <div title="供应商管理" data-options="iconCls:'icon-reload'" style="padding:10px;">
                <ul class="easyui-tree">
                    <li><a class="opts" title="供应商查看" url="/supplier/supplier"><span style="display: block;width: 180px">供应商查看</span></a></li>
                </ul>
            </div>



        </div>
    </div>
    <div data-options="region:'center'" style="padding:5px;">
        <div id="content" class="easyui-tabs" data-options="fit:true">
        </div>
    </div>
</div>
<div id="index-dialog">

</div>

</body>
</html>
