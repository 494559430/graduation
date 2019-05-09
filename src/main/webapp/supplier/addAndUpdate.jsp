<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<script>
    $.extend($.fn.validatebox.defaults.rules, {
        num: {
            validator: function(value, param){
                var reg = new RegExp("^[0-9]*[.]*[0-9]*$");
                return reg.test(value);
            },
            message: '请输入数字'
        },
        mobile: {
            validator: function (value, param) {
                return /^(?:13\d|15\d|18\d)-?\d{5}(\d{3}|\*{3})$/.test(value);
            },
            message: '手机号码不正确'
        },
        idCode:{
            validator:function(value,param){
                return /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(value);
            },
            message: '请输入正确的身份证号'
        }
    });
</script>
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
				<input name="suppliername" class="easyui-validatebox" data-options="required:true,width:180,validType:'length[1,20]'" value="${s.suppliername }"/>
				</c:when>
				<c:otherwise>${s.suppliername}<input  name="suppliername" type="hidden" value="${s.suppliername}"/></c:otherwise>
			</c:choose>
			</td>
		</tr>

		<tr>
			<td>供应商邮箱:</td>
			<td>
				<input name="supplieremail" class="easyui-validatebox" data-options="required:true,width:180,validType:'email'" value="${s.supplieremail }"/>
			</td>
		</tr>

		<tr>
			<td>供应商电话:</td>
			<td>
				<input name="supplierphone" class="easyui-validatebox" data-options="required:true,width:180,validType:'mobile'" value="${s.supplierphone }"/>
			</td>
		</tr>

		<tr>
			<td>供应商负责人:</td>
			<td>
				<input name="representative" class="easyui-validatebox" data-options="required:true,width:180,validType:'length[1,20]'" value="${s.representative}"/>
			</td>
		</tr>

	</table>
</form>
</body>
