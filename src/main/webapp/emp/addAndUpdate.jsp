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
<form id="emp-form" method="post">

	<table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">
		<c:if test="${not empty e}">

			<tr>
				<td>员工编号:</td>
				<td>${e.empid}<input name="empid" type="hidden" value="${e.empid}"/></td>
			</tr>

		</c:if>
		<tr>
			<td>员工名称:</td>
			<td>
				<input name="empname" class="easyui-validatebox"  data-options="required:true,width:180,validType:'length[1,20]'" value="${e.empname }"/>
			</td>
		</tr>
		<tr>
			<td>性别:</td>
			<td>
				<input name="sex" type="radio" value="1" checked/>男
				<input name="sex" type="radio" value="0" />女
			</td>
		</tr>
		<tr>
			<td>年龄:</td>
			<td>
				<input name="age" class="easyui-validatebox" data-options="required:true,width:180,validType:'num'" value="${e.age }"/>
			</td>
		</tr>
		<tr>
			<td>身份证号:</td>
			<td>
				<input name="idcard" class="easyui-validatebox" data-options="required:true,width:180,validType:'idCode'" value="${e.idcard }"/>
			</td>
		</tr>
		<tr>
			<td>员工电话:</td>
			<td>
				<input name="phone" class="easyui-validatebox" data-options="required:true,width:180,validType:'mobile'" value="${e.phone }"/>
			</td>
		</tr>
		<tr>
			<td>员工邮箱:</td>
			<td>
				<input name="email" class="easyui-validatebox" data-options="required:true,width:180,validType:'email'" value="${e.email }"/>
			</td>
		</tr>
		<tr>
			<td>家庭住址:</td>
			<td>
				<input name="loc" class="easyui-validatebox" data-options="required:true,width:180,validType:'length[1,100]'" value="${e.loc}"/>
			</td>
		</tr>

		<c:if test="${e.state==0}">
			<tr>
				<td>离职日期:</td>
				<td>
						${e.leavedate}
				</td>
			</tr>

		</c:if>

		<tr>
			<td>员工薪资:</td>
			<td>
				<a id="sub" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="subSal()"></a>
				<input id="sal" name="sal" class="easyui-validatebox" value="${e.sal}" data-options="required:true,width:180,validType:'num'" />
				<a id="add" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addSal()"></a>

			</td>
		</tr>
		<tr>
			<td>员工职位:</td>
			<td>
				<input id="cc" name="jobid" class="easyui-combobox"
					   data-options="required:true,width:180,editable:false,valueField:'id',textField:'text',
						url:'${pageContext.request.contextPath }/emp/getJob?shopid=${user.shopId}',method:'post',
						animate:true,value:'${e.jobid}'"
					/>
			</td>
		</tr>
	</table>
</form>
</body>
