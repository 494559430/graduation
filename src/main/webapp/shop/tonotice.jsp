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
    <%--<script src="${pageContext.request.contextPath}/js/shop/shop.js"></script>--%>
</head>
<body>
<table id="dg"></table>
<div class="mail-body">
    <div class="mail-body">

        <form class="form-horizontal" method="get">
            <div class="form-group">
                <label class="col-sm-2 control-label">发送到：</label>

                <div class="col-sm-10">
                    <input id="shopid" name="shopid" class="easyui-combobox" data-options="width:180,
					url:'${pageContext.request.contextPath }/shop/getshopList1',method:'post',multiple:true,animate:true,valueField:'id',textField:'text'
					"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">主题：</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" value="" id="title" >
                </div>
            </div>
        </form>

    </div>
<div class="mail-text h-200">

    <div class="summernote">

    </div>
    <div class="clearfix"></div>
</div>
<div class="mail-body text-right tooltip-demo">
    <a href="#" onclick="save()" class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top" title="Send"><i class="fa fa-reply"></i> 发送</a>
</div>
</div>
<!-- 全局js -->
<%--<script src="../js/jquery.min.js?v=2.1.4"></script>--%>
<script src="../js/bootstrap.min.js?v=3.3.6"></script>



<!-- 自定义js -->
<script src="../js/content.js?v=1.0.0"></script>


<!-- iCheck -->
<script src="../js/plugins/iCheck/icheck.min.js"></script>

<!-- SUMMERNOTE -->
<script src="../js/plugins/summernote/summernote.min.js"></script>
<script src="../js/plugins/summernote/summernote-zh-CN.js"></script>
<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });


        $('.summernote').summernote({
            lang: 'zh-CN'
        });

    });
    var edit = function () {
        $('.click2edit').summernote({
            focus: true
        });
    };
    var save = function () {
        var content = $('.summernote').code();
        var shopid = $('#shopid').combobox("getValues");
        var title = $('#title').val();
        var shopids="";
        for(var i =0;i<shopid.length;i++){
            shopids+=shopid[i]+",";
        }
        shopids=shopids.substring(0,shopids.length-1);
        console.log(shopids);
       $.ajax({
            type: "post",
            url: "/notice/addNotice",
//      data: "para="+para,  此处data可以为 a=1&b=2类型的字符串 或 json数据。
            data: {"title":title,"content":content,"shopids":shopids},
            cache: false,
            async : false,
            dataType: "json",
            success: function (data)
            {
                alert(data.msg);

            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });

    };
</script>
</body>
</html>
