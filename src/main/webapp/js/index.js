
$(function () {
    $("a.opts").click(function(){
        var url = $(this).attr("url");

        if (url!=undefined && url!=null && url!=""){
            //选项卡参数
            var option = {
                title : $(this).attr("title"),
                content:'<iframe src="'+ contextPath + url +'" height="100%" width="100%" frameborder="0" scrolling="auto"></iframe>'
            }
            tabs(option);
        }
    })
})

function tabs(option) {
    var tabs = $("#content");

    if($(tabs).tabs("exists",option.title)){
        //存在的话，选中
        $(tabs).tabs("select",option.title)
        var tab = $(tabs).tabs("getTab",option.title);
        tabs.tabs('update', {
            tab: tab,
            options: {
                title: option.title,
                content:option.content,
                closable:true
            }
        });
    }else {
        //选项卡不存在，创建新的
        $(tabs).tabs('add',{
            title:option.title,
            content:option.content,
            closable:true
        });

    }


}

// function logout() {
//     window.location.replace(contextPath+"/login/logout");
// }


// function editPass(){
//     $("#index-dialog").dialog({
//         title: '修改密码',
//         width: 400,
//         height: 380,
//         closed: false,
//         // href: contextPath+"/emp/editPassword",
//         content:'<iframe id = "ep" src="'+ contextPath + '/emp/editPassword' +'" height="100%" width="100%" frameborder="0" scrolling="auto"></iframe>',
//         modal: true,--
//         buttons:[{
//             text:"修改",
//             iconCls:'icon-edit',
//             handler:function () {
//
//                 $("#ep")[0].contentWindow.$("#editPass-form").form("submit",{
//                     url:contextPath+'/emp/editPass',
//                     onSubmit:function (p) {
//                         // $("#ep").contents().find("#editPass-form").form("clear");
//                         // alert($("#ep").contents().find("#editPass-form").form("validate"));
//                         // console.log($("#ep").contents().find("#password1").val())
//                         return $("#ep")[0].contentWindow.$("#editPass-form").form("validate");
//                     },
//                     //参数不处理json
//                     success:function (msg) {
//                         var data = $.parseJSON(msg);
//                         if(data.code === 200){
//                             $("#index-dialog").dialog("close");
//                             $("#index-dialog").dialog("clear");
//                         }
//                         $.messager.show({
//                             title:'我的消息',
//                             msg:data.msg,
//                             timeout:5000,
//                             showType:'slide'
//                         });
//                     }
//                 });
//             }
//         }]
//     })
// }
