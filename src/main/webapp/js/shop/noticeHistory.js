/**
 * Created by 85181 on 2019/5/8.
 */
$(function () {
    $('#dg').datagrid({
        url: contextPath + '/notice/getAllNotice',
        striped: true,
        loadMsg: 'loading.....',
        pagination: true,
        rownumbers: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 20, 30],
       /* checkOnSelect:true,*/
        fit: true,
        fitColumns:true,
        singleSelect:false,
        columns: [[

            {title: "标题", field: "title",align:"center",width:150},
            {title: "内容", field: "content",align:"center",width:300},
            {title: "时间", field: "date",align:"center",width:75},
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
    },
    delete:function () {
        var s = $('#dg').datagrid("getSelections");
        if (s ==null){
            $.messager.show({
                title:'提示',
                msg:"请选中至少一条记录",
                timeout:5000,
                showType:'slide'
            });
            return ;
        }
        var ids = [];
        $.each(s, function(index, item){
            ids.push(item.id);
        });
        if(confirm('确定要删除'+s.length+'条消息吗？')==true){

            $.ajax({
                type: "post",
                url: contextPath+"/notice/deleteNotice?ids="+ids.join(","),
                dataType: "json",
                success: function(msg){
                    var data = msg;
                    if(data.code === 200){
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

        }else{

            return ;

        }

    }



}