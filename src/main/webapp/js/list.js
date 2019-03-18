$(function () {
    $('#dg').datagrid({
        url: contextPath + '/room/list',
        striped: true,
        loadMsg: 'loading.....',
        pagination: true,
        rownumbers: true,
        pageNumber: 1,
        pageSize: 5,
        pageList: [3, 5, 10],
        fit: true,
        fitColumns:true,
        columns: [[
            // 复选框、单车编号、单车型号、供应商、单车类别、剩余数量、操作按钮。
            // {title: "复选框", field: "id",checkbox:true},
            {title: "房间号", field: "rnum",align:"center",width:150},
            {title: "房间类型", field: "rtype",align:"center",width:150},
            {title: "住宿单价", field: "rprice",align:"center",width:150},
            {title: "房间设备", field: "rtool",align:"center",width:150},
            {title: "状态", field: "status",align:"center",width:250,formatter:function (value,row,index) {
                if (value==0){

                    return "空闲"
                }else{
                    return "已租";
                }

            }},
            {title: "操作", field: "do" ,align:"center",width:100,formatter:function (value,row,index) {
                return "<button onclick='eventobj.update2(\""+row.rid+"\")'>修改</button><button onclick='eventobj.remove2(\""+row.rid+"\")'>删除</button>";
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
            href: contextPath+"/pages/emp/query.jsp",
            modal: true,
            buttons:[{
                text:"查询",
                iconCls:'icon-search',
                handler:function () {
                    $('#dg').datagrid("load",{
                        rnum:$("#ename").textbox("getValue"),
                        startprice:$("#startprice").textbox("getValue"),
                        endprice:$("#endprice").textbox("getValue")
                    })
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
            href: contextPath+"/pages/emp/AddAndUpdate.jsp",
            modal: true,
            buttons:[{
                text:"添加",
                iconCls:'icon-add',
                handler:function () {
                    $("#emp-form").form("submit",{
                        url:contextPath+'/room/add',
                        onSubmit:function (p) {
                            p.etoak = "tonight";
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
    update:function () {
        var s = $('#dg').datagrid("getSelected");
        if (s ==null){
            $.messager.show({
                title:'提示',
                msg:"请选中至少一条记录",
                timeout:5000,
                showType:'slide'
            });
            return ;
        }
        $("#emp-dialog").dialog({
                title: '修改',
                width: 400,
                height: 480,
                closed: false,
                href: contextPath+"/emp/empAddAndUpdate?id="+s.id,
                modal: true,
                buttons:[{
                    text:'修改',
                    iconCls:'icon-edit',
                    handler:function () {
                        $("#emp-form").form("submit",{
                            url:contextPath+"/room/update",
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
    update2:function (id) {
        var s = id;
        if (s ==null){
            $.messager.show({
                title:'提示',
                msg:"请选中至少一条记录",
                timeout:5000,
                showType:'slide'
            });
            return ;
        }
        $("#emp-dialog").dialog({
            title: '修改',
            width: 400,
            height: 480,
            closed: false,
            href: contextPath+"/room/empAddAndUpdate?rid="+id,
            modal: true,
            buttons:[{
                text:'修改',
                iconCls:'icon-edit',
                handler:function () {
                    $("#emp-form").form("submit",{
                        url:contextPath+"/room/update",
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
    remove:function () {
        var s = $('#dg').datagrid("getSelections");
        if (s.length ==0){
            $.messager.show({
                title:'提示',
                msg:"请选中至少一条记录",
                timeout:5000,
                showType:'slide'
            });
            return ;
        }
        $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
            if (r){
                var bids = $.map(s,function (a) {
                    return a.bid;
                })
                $.ajax({
                    url:contextPath+"/bike/del",
                    contentType:'application/json',
                    data:JSON.stringify(bids),
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
    },
    remove2:function (rid) {

        $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
            if (r){
                $.ajax({
                    url:contextPath+"/room/del?id="+rid,
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
}