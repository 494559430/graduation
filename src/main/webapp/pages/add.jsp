<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	
		function add(){
			$.ajax({
				url:"${pageContext.request.contextPath}/user/add",	
				data:$("#user-form").serialize(),
				dataType:"json",
				type:"post",
				success:function(data){
                    alert(data.msg+"!!!");
					if(data.flag=="success"){
					alert("成功!!!");
					}
				},
				error:function(data){
					alert("sb");
                    alert(data.msg+"!!!");
				}
			});
			
		}
		
	
</script>
</head>
<body>

	<form id="user-form">
		用户：<input name="username" type="text"/> <br/>
		密码：<input name="password" type="password"/> <br/>
		<input type="button" value="提交" onclick="add()" />
	</form>



</body>
</html>