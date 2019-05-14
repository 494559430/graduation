/**
 * Created by 85181 on 2019/5/8.
 */
$(function () {
    $('#dg').datagrid({
        url: contextPath + '/notice/getList',
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
            //{title: "复选框", field: "id",checkbox:true},
            {title: "标题", field: "title",align:"center",width:150},
            {title: "内容", field: "content",align:"center",width:300},
            {title: "时间", field: "date",align:"center",width:75},
            {title: "状态", field: "isRead",align:"center",width:75,formatter:function (value,row,index) {
                if (value=='1')
                    return "未读";
                else
                    return "已读";
            }},
            {title: "操作", field: "do" ,align:"center",width:50,formatter:function (value,row,index) {
                return "<button onclick='eventobj.detail(\""+row.id+"\")'>查看</button>";
            }}
        ]],
        toolbar: '#dg-toolbar'
    });
})

var eventobj = {
    query0:function (){


        $("#dg").datagrid('load',{
            isRead:"1"
        });
    },
    query1:function (){


        $("#dg").datagrid('load',{
            isRead:"2"
        });
    },
    detail:function (id) {
        $("#notice-dialog").dialog({
            title: '通知',
            width: 800,
            height: 500,
            closed: false,
            href: contextPath + "/notice/getDetail?id="+id,
            modal: true,
            buttons: [{
                text: "确认",
                handler: function () {
                    $("#notice-dialog").dialog("close");
                    $("#notice-dialog").dialog("clear");
                    $('#dg').datagrid("reload");
                }

            }]
        })
    }



}