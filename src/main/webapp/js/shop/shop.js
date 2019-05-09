/**
 * Created by 85181 on 2019/5/8.
 */
$(function () {
    $('#dg').datagrid({
        url: contextPath + '/shop/getList',
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
            {title: "编号", field: "shopid",align:"center",width:150},
            {title: "商店名称", field: "shopname",align:"center",width:150},
            {title: "商店地址", field: "shopaddress",align:"center",width:150},
            {title: "操作", field: "do" ,align:"center",width:175,formatter:function (value,row,index) {
                return "<button onclick='eventobj.detail(\""+row.shopid+"\")'>商店详情</button>";
            }}
        ]],
        toolbar: '#dg-toolbar'
    });
})

var eventobj = {
    query:function (){
        var str = document.getElementById('shopid').value.trim();
        if(str.length!=0){
            reg=/^\d*$/;
            if(!reg.test(str)){
                alert("对不起，商店编号只为整数!");
                return;
            }


        }
        $("#dg").datagrid('load',{
            shopid:$("#shopid").val(),
            shopname:$("#shopname").val(),
            shopaddress:$("#shopaddress").val(),
        });
    },
    detail:function (shopid) {
        $("#supplier-dialog").dialog({
            title: '商店详情',
            width: 400,
            height: 300,
            closed: false,
            href: contextPath + "/shop/getDetail?shopid="+shopid,
            modal: true,
            buttons: [{
                text: "确认",
                handler: function () {
                    $("#supplier-dialog").dialog("close");
                    $("#supplier-dialog").dialog("clear");
                    $('#dg').datagrid("reload");
                }

            }]
        })
    },
    add:function () {
            $("#supplier-dialog").dialog({
                title: '商店添加',
                width: 400,
                height: 300,
                closed: false,
                href: contextPath + "/turn/toshopAdd",
                modal: true,
                buttons: [{
                    text: "添加",
                    handler: function () {
                        $("#supplier-form").form("submit", {
                            url: contextPath + "/shop/add",
                            onSubmit: function () {
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
            })
        },
    update: function(){
        var s = $('#dg').datagrid("getSelected");
        if (s ==null){
            $.messager.show({
                title:'提示',
                msg:"请选中一条记录",
                timeout:5000,
                showType:'slide'
            });
            return ;
        }
        $("#supplier-dialog").dialog({
            title: '商店修改',
            width: 400,
            height: 300,
            closed: false,
            href: contextPath + "/shop/toupdate?shopid="+s.shopid,
            modal: true,
            buttons: [{
                text: "修改",

                handler: function () {
                    $("#supplier-form").form("submit", {
                        url: contextPath + "/shop/update?shopid="+s.shopid,
                        onSubmit: function () {

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
        })
    },

}