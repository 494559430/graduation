<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<h2>
	${n.title}
</h2>
<div class="mail-tools tooltip-demo m-t-md">
	<h5>
		<span class="pull-right font-noraml">${n.date}</span>

	</h5>

	<h3>
		<span class="font-noraml">内容： </span>
	</h3>

</div>
</div>
<div class="mail-box">


	<div class="mail-body">
		${n.content}
	</div>
</div>
</body>
