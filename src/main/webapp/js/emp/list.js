$(function () {
    $('#dg').datagrid({
        url: contextPath + '/emp/list',
        striped: true,
        loadMsg: 'loading.....',
        pagination: true,
        rownumbers: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 20, 30],
        fit: true,
        fitColumns:true,
        columns: [[
            // 复选框、单车编号、单车型号、供应商、单车类别、剩余数量、操作按钮。
            // {title: "复选框", field: "id",checkbox:true},
            {title: "姓名", field: "empname",align:"center",width:150},
            {title: "性别", field: "sex",align:"center",width:50,formatter:function (value,row,index) {
                if (value==0){
                    return "女"
                }else if (value==1){
                    return "男";
                }

            }},

            {title: "职位", field: "jobName",align:"center",width:150},
            {title: "薪资", field: "sal",align:"center",width:150},
            {title: "入职时间", field: "hiredate",align:"center",width:250},
            {title: "状态", field: "state",align:"center",width:75,formatter:function (value,row,index) {
                if (value=='1'){
                    return "离职"
                }else if (value=='3'){
                    return "店长";
                }else{
                    return "店员";
                }

            }},
            {title: "操作", field: "do" ,align:"center",width:175,formatter:function (value,row,index) {
                return "<button onclick='eventobj.update(\""+row.empid+"\")'>修改</button><button onclick='eventobj.remove2(\""+row.empid+"\")'>解雇</button>";
            }}
        ]],
        toolbar: '#dg-toolbar'


    });
})




var eventobj = {
    query :function () {
        $("#emp-dialog").dialog({
            title: '查询',
            width: 400,
            height: 380,
            closed: false,
            href: contextPath+"/emp/query.jsp",
            modal: true,
            buttons:[{
                text:"查询",
                iconCls:'icon-search',
                handler:function () {
                    $("#dg").datagrid('load',{
                        empname:$("#empname").textbox("getValue"),
                        jobid:$("#jobId").combobox("getValue"),
                        state:$("#state").combobox("getValue"),
                        hiredateStart:$("#hiredateStart").datebox("getValue"),
                        hiredateEnd:$("#hiredateEnd").datebox("getValue")
                    });
                    $("#emp-dialog").dialog("close");
                    $("#emp-dialog").dialog("clear");
                }
            }]
        })
    },
    add :function () {
        $("#emp-dialog").dialog({
            title: '添加',
            width: 400,
            height: 480,
            closed: false,
            href: contextPath+"/emp/addAndUpdate",
            modal: true,
            buttons:[{
                text:"添加",
                iconCls:'icon-add',
                handler:function () {
                    $("#emp-form").form("submit",{
                        url:contextPath+'/emp/addEmp',
                        onSubmit:function (p) {
                            //p.etoak = "tonight";
                            //验证emp-form表单项是否非空
                            return $("#emp-form").form("validate");
                        },
                        //参数不处理json
                        success:function (msg) {
                            var data = $.parseJSON(msg);
                            if(data.code === 200){
                                $("#emp-dialog").dialog("close");
                                $("#emp-dialog").dialog("clear");
                                $('#dg').datagrid("reload");

                            }
                            $.messager.show({
                                title:'我的消息',
                                msg:data.msg,
                                timeout:5000,
                                showType:'slide'
                            });
                        }
                    });

                }
            }]
        })

    },
    update:function (empid) {
        /*var s = $('#dg').datagrid("getSelected");
        if (s ==null){
            $.messager.show({
                title:'提示',
                msg:"请选中至少一条记录",
                timeout:5000,
                showType:'slide'
            });
            return ;
        }*/
        $("#emp-dialog").dialog({
                title: '员工详细信息',
                width: 400,
                height: 550,
                closed: false,
                href: contextPath+"/emp/addAndUpdate?id="+empid,
                modal: true,
                buttons:[{
                    text:'修改',
                    iconCls:'icon-edit',
                    handler:function () {
                        $("#emp-form").form("submit",{
                            url:contextPath+"/emp/update",
                            onSubmit:function (p) {
                                // p.id = s.id;
                                return $("#emp-form").form("validate");
                            },
                            success:function (msg) {
                                var data = $.parseJSON(msg);
                                if(data.code === 200){
                                    $("#emp-dialog").dialog("close");
                                    $("#emp-dialog").dialog("clear");
                                    $('#dg').datagrid("reload");
                                }
                                $.messager.show({
                                    title:'我的消息',
                                    msg:data.msg,
                                    timeout:5000,
                                    showType:'slide'
                                });
                            }
                        })
                    }
                }]

        });
    },
    addJob:function (id) {

        $("#emp-dialog").dialog({
            title: '添加职位',
            width: 400,
            height: 200,
            closed: false,
            href: contextPath+"/emp/toAddJob",
            modal: true,
            buttons:[{
                text:'添加',
                iconCls:'icon-edit',
                handler:function () {
                    $("#toAddJob-form").form("submit",{
                        url:contextPath+"/emp/addJob",
                        onSubmit:function (p) {
                            // p.id = s.id;
                            //alert("sbsb");


                            return $("#toAddJob-form").form("validate");
                        },
                        success:function (msg) {
                            var data = $.parseJSON(msg);
                            if(data.code === 200){
                                $("#emp-dialog").dialog("close");
                                $("#emp-dialog").dialog("clear");
                                $('#dg').datagrid("reload");
                            }
                            $.messager.show({
                                title:'我的消息',
                                msg:data.msg,
                                timeout:5000,
                                showType:'slide'
                            });
                        }
                    })
                }
            }]

        });
    },
    remove2:function (empid) {

        $.messager.confirm('确认','您确认想要解雇员工编号为的'+empid+'员工吗？',function(r){
            if (r){
                $.ajax({
                    url:contextPath+"/emp/del?empid="+empid,
                    contentType:'application/json',
                    type:"post",
                    success:function (msg) {

                        $.messager.show({
                            title:'我的消息',
                            msg:msg.msg,
                            timeout:5000,
                            showType:'slide'
                        });
                        $('#dg').datagrid("reload");
                    }
                })
            }
        });
    }
};
function addSal(){
    var sal =parseInt($("#sal").val());
    sal +=100;
    $("#sal").val(sal);
}
function subSal(){
    var sal =parseInt($("#sal").val());
    sal -=100;
    $("#sal").val(sal);
}