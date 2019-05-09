<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/4/6
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品种类</title>
    <%@include file="/easyui/include.jsp"%>
    <link rel="stylesheet" href="../css/zTreeStyle/zTreeStyle.css">
    <script src="${pageContext.request.contextPath}/js/jquery.ztree.all.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ztree.core.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ztree.excheck.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ztree.exedit.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ztree.exhide.js"></script>


</head>
<body>
    <table>
        <tr>
            <td><ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul></td>
            <td rowspan="2"></td>
        </tr>
        <tr>
            <td><button onclick="addParent()">添加父种类</button>
                <button onclick="addSon()">添加子种类</button></td>

        </tr>
    </table>


    <div id="supplier-dialog">

    </div>
</body>
<script>
    function addParent(){
        $("#supplier-dialog").dialog({
            title: '父类添加',
            width: 400,
            height:200,
            closed: false,
            href: contextPath + "/ShopItemTypeController/toaddParent",
            modal: true,
            buttons: [{
                text: "添加",

                handler: function () {
                    $("#supplier-form").form("submit", {
                        url: contextPath + "/ShopItemTypeController/addParent",
                        onSubmit: function () {
                            return $("#supplier-form").form("validate");
                        },

                        success:function (msg) {
                            var data = $.parseJSON(msg);
                            if(data.code === 200){
                                $("#supplier-dialog").dialog("close");
                                $("#supplier-dialog").dialog("clear");
                                getTree();

                            }
                            $.messager.show({
                                title:'我的消息',
                                msg:data.msg,
                                timeout:5000,
                                showType:'slide'
                            });
                        }
                    })
                }

            }]
        })
    }

    function addSon(){
        $("#supplier-dialog").dialog({
            title: '子类添加',
            width: 400,
            height: 200,
            closed: false,
            href: contextPath + "/ShopItemTypeController/toaddSon",
            modal: true,
            buttons: [{
                text: "添加",

                handler: function () {
                    $("#supplier-form").form("submit", {
                        url: contextPath + "/ShopItemTypeController/addSon",
                        onSubmit: function () {
                            return $("#supplier-form").form("validate");
                        },

                        success:function (msg) {
                            var data = $.parseJSON(msg);
                            if(data.code === 200){
                                $("#supplier-dialog").dialog("close");
                                $("#supplier-dialog").dialog("clear");
                                getTree();

                            }
                            $.messager.show({
                                title:'我的消息',
                                msg:data.msg,
                                timeout:5000,
                                showType:'slide'
                            });
                        }
                    })
                }

            }]
        })
    }
    var nodes = [
        {id:1, pId:0, name: "父节点1"},
        {id:11, pId:1, name: "子节点1"},
        {id:12, pId:1, name: "子节点2"}
    ];

    var setting = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },

        data: {
            key:{
                name:"typename"
            },
            simpleData: {
                enable: true,
                idKey: "typeid",
                pIdKey: "parentid",
                rootPId: ""
            }
        }
    }

     $(document).ready(function () {
     getTree()
     });

    function getTree(){
        $.ajax({
            type: "GET",
            url: contextPath+"/ShopItemTypeController/getItemType",
            dataType: "json",
            success: function(data){
                var t = $("#tree");
                t = $.fn.zTree.init(t, setting, data);

            }
        });

    }


   /* var zTree = $.fn.zTree.getZTreeObj("tree");
    zTree.selectNode(zTree.getNodeByParam("id", 101));*/

</script>
</html>
