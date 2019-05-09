<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/easyui/include.jsp"%>

    <title>QDU超市后台管理登录</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">青大</h1>

            </div>
            <h3>欢迎使用超市后台管理系统</h3>

            <form class="m-t" role="form" action="/user/login" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" required="required" name="username" id="username">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required="required" name="password" id="password">
                </div>
                <button type="button" class="btn btn-primary block full-width m-b" onclick="login()">登 录</button>


                <p class="text-muted text-center">若无帐号请联系 兰博卢基尼
                </p>

            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script>
    function login() {
        var username= $("#username").val();
        var password= $("#password").val();
        $.ajax({
            type: "post",
            url: "/user/login",
//      data: "para="+para,  此处data可以为 a=1&b=2类型的字符串 或 json数据。
            data: {"username":username,"password":password},
            cache: false,
            async : false,
            dataType: "json",
            success: function (data)
            {
                if("1"==data.code){
                    alert(data.msg);
                    window.location.replace(contextPath+"/index1.jsp");
                }else{
                    alert(data.msg);
                    return false;
                }
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });
    }

    </script>


</body>

</html>
