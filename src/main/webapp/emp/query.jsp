<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>

		<table style="margin:20px auto;" cellpadding="5px" cellspacing="5px">
			<tr>
				<td>员工名称:</td>
				<td>
					<input id="empname" name="empname" class="easyui-textbox" data-options="width:180"/>
				</td>
			</tr>
			
			
			<tr>
				<td>员工职位:</td>
				<td>
					<input id="jobId" name="jobid" class="easyui-combobox" data-options="width:180,
					url:'${pageContext.request.contextPath }/emp/getJob',method:'post',animate:true,valueField:'id',textField:'text'
					"/>
				</td>
			</tr>
			<tr>
				<td>状态:</td>
				<td>
					<input id="state" name="state" class="easyui-combobox" data-options="width:180,
					method:'post',animate:true,valueField:'id',textField:'text',
					data:[{
						text:'已离职',
						id:'1'
					},{
						text:'店员',
						id:'2'
					}]"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">雇佣时间:</td>

			</tr>
			<tr>
				<td>
					<input id="hiredateStart" name="hiredateStart" class="easyui-datebox" data-options="width:140"/>至
				</td>

				<td>
					<input id="hiredateEnd" name="hiredateEnd" class="easyui-datebox" data-options="width:140"/>
				</td>
			</tr>

		</table>

</body>
