/**
 * Created by 85181 on 2019/5/2.
 */
$(function () {
    $('#dg').datagrid({
        url: contextPath + '/shopItem/getList',
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
            {title: "编号", field: "shopitemid",align:"center",width:150},
            {title: "商品名称", field: "shopitemname",align:"center",width:150},
            {title: "库存", field: "num",align:"center",width:150},
            {title: "是否上架", field: "ifgroundingStr",align:"center",width:150},
            {title: "操作", field: "do" ,align:"center",width:175,formatter:function (value,row,index) {
                return "<button onclick='eventobj.detail(\""+row.shopitemid+"\")'>商品详情</button>";
            }}
        ]],
        toolbar: '#dg-toolbar'


    });
})

$.ajax({
    type: "post",
    url: contextPath + "/shop/getshopList",
    dataType: "json",
    success: function (data) {
        for(var i in data){
            $("#shopid")[0].innerHTML=$("#shopid")[0].innerHTML+"<option value='"+data[i].shopid+"'>"+data[i].shopname+"</option>"
        }
    }
})

var eventobj = {
    query:function (){
        var str = document.getElementById('shopitemid').value.trim();
        if(str.length!=0){
            reg=/^\d*$/;
            if(!reg.test(str)){
                alert("对不起，商品编号只为整数!");//请将“整数类型”要换成你要验证的那个属性名称！
                return;
            }
        }
        $("#dg").datagrid('load',{
            shopitemid:$("#shopitemid").val(),
            shopitemname:$("#shopitemname").val(),
            shopid:$("#shopid").val(),
        });
    },
    detail: function (shopitemid) {
        $("#supplier-dialog").dialog({
            title: '商品详情',
            width: 400,
            height: 300,
            closed: false,
            href: contextPath + "/shopItem/getDetail?shopitemid="+shopitemid,
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
            title: '商品修改',
            width: 600,
            height: 500,
            closed: false,
            href: contextPath + "/shopItem/update?shopitemid="+s.shopitemid,
            modal: true,
            buttons: [{
                text: "修改",

                handler: function () {
                    $("#supplier-form").form("submit", {
                        url: contextPath + "/shopItem/update2?shopitemid="+s.shopitemid,
                        onSubmit: function () {

                            return $("#supplier-form").form("validate");
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
        })
    },
    add: function(){

        $("#supplier-dialog").dialog({
            title: '商品添加',
            width: 600,
            height: 500,
            closed: false,
            href: contextPath + "/turn/toshopItemAdd",
            modal: true,
            buttons: [{
                text: "添加",

                handler: function () {
                    $("#supplier-form").form("submit", {
                        url: contextPath + "/shopItem/add",
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
    }
}