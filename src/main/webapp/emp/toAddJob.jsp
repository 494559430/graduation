<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/easyui/include.jsp" %>
<body>
	<form id="toAddJob-form" method="post">
	
		<table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">
			
			<tr>
				<td>职位名称:</td>
				<td>
					<input id="jobname" name="jobname" class="easyui-combobox"
    				data-options="valueField:'id',required:true,textField:'text'" />
				</td>
			</tr>

		</table>

	</form>
</body>

