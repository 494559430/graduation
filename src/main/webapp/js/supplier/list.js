$(function () {
    $('#dg').datagrid({
        url: contextPath + '/supplier/list',
        striped: true,
        loadMsg: 'loading.....',
        pagination: true,
        rownumbers: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 20, 30],
        fit: true,
        fitColumns:true,
        singleSelect:true,
        columns: [[
            // {"复选框", field: "id",checkbox:true},title:
            {title: "编号", field: "supplierid",align:"center",width:150},
            {title: "供应商", field: "suppliername",align:"center",width:150},
            {title: "负责人", field: "representative",align:"center",width:50},
            {title: "供应商邮箱", field: "supplieremail",align:"center",width:150},
            {title: "供应商电话", field: "supplierphone",align:"center",width:150},
            {title: "操作", field: "do" ,align:"center",width:175,formatter:function (value,row,index) {

                    return "<button onclick='eventobj.select(\"" + row.supplierid + "\")'>供应商品信息</button>";
               }}
        ]],
        toolbar: '#dg-toolbar'


    });
})




var eventobj = {
    query :function () {

        $("#dg").datagrid('load',{
            suppliername:$("#suppliername").textbox("getValue"),
            representative:$("#representative").textbox("getValue"),

        });

    },
    select :function (supplierid) {

        $("#supplier-dialog").dialog({
            title: '供应商品详细信息',
            width: 1000,
            height: 500,
            closed: false,
            href: contextPath+"/shopItem/queryBySupplierid?supplierid="+supplierid,
            modal: true,
            buttons:[{
                text:'确认',
                iconCls:'icon-edit',
                handler:function () {
                    $("#supplier-dialog").dialog("close");
                    $("#supplier-dialog").dialog("clear");
                    $('#dg').datagrid("reload");
                }
            }]

        });
    },
    add :function () {
        $("#supplier-dialog").dialog({
            title: '添加',
            width: 400,
            height: 300,
            closed: false,
            href: contextPath+"/supplier/addAndUpdate.jsp",
            modal: true,
            buttons:[{
                text:"添加",
                iconCls:'icon-add',
                handler:function () {
                    $("#supplier-form").form("submit",{
                        url:contextPath+'/supplier/addSupplier',
                        onSubmit:function (p) {
                            //p.etoak = "tonight";
                            //验证emp-form表单项是否非空
                            return $("#supplier-form").form("validate");
                        },
                        //参数不处理json
                        success:function (msg) {
                            var data = $.parseJSON(msg);
                            if(data.code === 200){
                                $("#supplier-dialog").dialog("close");
                                $("#supplier-dialog").dialog("clear");
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
    update:function (supplierid) {
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
        $("#supplier-dialog").dialog({
            title: '供应商详细信息',
            width: 400,
            height: 300,
            closed: false,
            href: contextPath+"/supplier/addAndUpdate?id="+s.supplierid,
            modal: true,
            buttons:[{
                text:'修改',
                iconCls:'icon-edit',
                handler:function () {
                    $("#supplier-form").form("submit",{
                        url:contextPath+"/supplier/update",
                        onSubmit:function (p) {
                            // p.id = s.id;
                            return $("#supplier-form").form("validate");
                        },
                        success:function (msg) {
                            var data = $.parseJSON(msg);
                            if(data.code === 200){
                                $("#supplier-dialog").dialog("close");
                                $("#supplier-dialog").dialog("clear");
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
    }


}