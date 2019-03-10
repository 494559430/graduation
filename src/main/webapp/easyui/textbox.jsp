<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/easyui/include.jsp" %>
<script type="text/javascript">
	$(function(){
		$.extend($.fn.validatebox.defaults.rules, {    
			etoak: {    
		        validator: function(value,param){    
		        	var reg=/^13\d{9}$/;
		            return reg.test(value) ;    
		        },    
		        message: '没有匹配'   
		    },
		    mima:{
		    	validator: function(value,param){    
		    		var reg=/^13\d{9}$/;
		            return reg.test(value) ; 
		        },    
		        message: '不是手机号'   
		    },
		    queren:{
		    	validator: function(value,param){    
		    		
		            return value==$(param[0]).val();
		        },    
		        message: '与上面的密码不一致'   
		    }
		});  

		 $('#tb').textbox({ 
			required:true,
		    buttonText:'Search',    
		    iconCls:'icon-man', 
		    iconAlign:'left',
		    //missingMessage:'空了！',
		   	validType:['etoak["etoak"]'],
		    //invalidMessage:'格式不太对',
		    //onClickButton:function(){$(this).textbox('setValue','qqqqqq') }
		}); 
		
		$("#test2").textbox({
			buttonText:'测试2',
			required:'true',
			validType:'queren["#test"]',
			onClickButton:function(){$('#test2').textbox('setValue','sbsb');
			
			
			}
		});
		
		$('#p1').panel({    
			  width:800,    
			  height:800,    
			  title: 'My Panel',
			  collapsible:true,
			  tools: [{    
			    iconCls:'icon-add',    
			    handler:function(){
			    	$('#tt').tabs('add',{    
					    title:'New Tab',    
					    content:'Tab Body',    
					    closable:true,    
					    tools:[{    
					        iconCls:'icon-mini-refresh',    
					        handler:function(){    
					            alert('refresh');    
					        }    
					    }]    
					});
			    }    
			  },{    
			    iconCls:'icon-save',    
			    handler:function(){alert('save')}    
			  }]    
				}); 
		
		/* $('#tt').tabs({    
		    border:false,    
		    onSelect:function(title){    
		        alert(title+' is selected');    
		    }    
		});   */
		  
		
	});
	var option=$('#tb').textbox("option");
	//console.log(option);  
	
</script>
</head>
<body>
	<input class="easyui-textbox" data-options="width:300,prompt:'sbsbsbsbsb',value:'sbsb',multiline:true
	,readonly:false,iconCls:'icon-ok',iconAlign:'left',buttonText:'sbsbsbbs',buttonIcon:'icon-edit',onClickButton:function(){$(this).textbox('setValue','qqqqqq') }"  /> <br/>
	<input id="tb" type="text" style="width:300px">
	<br/>
	密码：<input id="test" class="easyui-textbox" data-options="
	validType: 'mima',required:'true',missingMessage:'空了！',buttonText:'test1',
	onClickButton:function(){
			$('#p').panel('move',{    
		  left:100,    
		  top:100    
	});}
	"/>
	<br/>
	确认：<input id="test2" class="easyui-textbox"/>
	<hr/>
	
	
	
	<div id="p1" style="padding:10px;">
	<div id="tt" class="easyui-tabs" style="width:500px;height:500px;">   
	    <div title="Tab1" style="padding:20px;display:none;">   
			<div id="cc" class="easyui-layout" style="width:600px;height:400px;">   
			    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>   
			    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>   
			    <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>   
			    <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>   
			    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>   
			</div>    
	    </div>   
	    <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">   
		<div id="aa" class="easyui-accordion" style="width:300px;height:200px;">   
			  <div title="Title1" data-options="iconCls:'icon-save'" style="padding:10px;">   
			      <h3 style="color:#0099FF;">Accordion for jQuery</h3>   
			      <p>Accordion is a part of easyui framework for jQuery.     
			      It lets you define your accordion component on web page more easily.</p>   
			  </div>   
			  <div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
			        content2    
			    </div>   
			    <div title="Title3">   
			        content3    
			    </div>   
		</div>     
	    </div>   
	    <div title="Tab3" class="easyui-droppable" data-options="accept:'#title',iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">   
	        tab3    
	    </div>   
	</div>         
	</div>    
   <div id="p" class="easyui-panel easyui-draggable easyui-resizable" title="My Panel"     
        style="width:500px;height:150px;padding:10px;background:#fafafa;"   
        data-options="handle:'#title',iconCls:'icon-save',closable:true, 
                collapsible:true,minimizable:true,maximizable:true"> 
	    <div id="title">title
	    <p>panel conten</p>   
	    <p>panel content.</p> 
	    </div>    
	</div>  
   <hr/>
   <div id="jindutiao" class="easyui-progressbar" data-options="value:100" style="width:400px;"></div> 
   <input class="easyui-slider" value="12"  style="width:300px"   
        data-options="showTip:true,rule:[0,'|',25,'|',50,'|',75,'|',100],range:true" />  
   
</body>
</html>