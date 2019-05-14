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

</head>
<body>
<table id="dg1"></table>

<div id="shopItem-dialog">

</div>
<script>
    $(function () {

        $('#dg1').datagrid({
            url: contextPath + '/shopItem/getList?supplierid=<%=request.getAttribute("supplierid")%>',
            striped: true,
            loadMsg: 'loading.....',
            pagination: true,
            rownumbers: true,
            pageNumber: 1,
            pageSize: 10,
            pageList: [10, 20, 30],
            fit: true,
            fitColumns:true,
            singleSelect:true,
            columns: [[
                // {"复选框", field: "id",checkbox:true},title:
                {title: "编号", field: "shopitemid",align:"center",width:150},
                {title: "商品名称", field: "shopitemname",align:"center",width:150},
                {title: "库存", field: "num",align:"center",width:150},
                {title: "定价", field: "price",align:"center",width:150},
                {title: "是否上架", field: "ifgroundingStr",align:"center",width:150},

            ]]


        });
    })

</script>
</body>
</html>
