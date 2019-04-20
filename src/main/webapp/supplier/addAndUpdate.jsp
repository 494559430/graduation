<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<form id="supplier-form" method="post">

	<table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">
		<c:if test="${not empty s}">

			<tr>
				<td>供应商编号:</td>
				<td>${s.supplierid}<input name="supplierid" type="hidden" value="${s.supplierid}"/></td>
			</tr>

		</c:if>

		<tr>
			<td>供应商名称:</td>
			<td>
			<c:choose>
				<c:when test="${empty s}">
				<input name="suppliername" class="easyui-textbox" data-options="required:true,width:180" value="${s.suppliername }"/>
				</c:when>
				<c:otherwise>${s.suppliername}<input name="suppliername" type="hidden" value="${s.suppliername}"/></c:otherwise>
			</c:choose>
			</td>
		</tr>

		<tr>
			<td>供应商邮箱:</td>
			<td>
				<input name="supplieremail" class="easyui-textbox" data-options="required:true,width:180" value="${s.supplieremail }"/>
			</td>
		</tr>

		<tr>
			<td>供应商电话:</td>
			<td>
				<input name="supplierphone" class="easyui-textbox" data-options="required:true,width:180" value="${s.supplierphone }"/>
			</td>
		</tr>

		<tr>
			<td>供应商负责人:</td>
			<td>
				<input name="representative" class="easyui-textbox" data-options="required:true,width:180" value="${s.representative}"/>
			</td>
		</tr>

	</table>
</form>
</body>
