<%--
  Created by IntelliJ IDEA.
  User: 85181
  Date: 2019/5/7
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/easyui/include.jsp"%>
    <script src="${pageContext.request.contextPath}/js/echarts.js"></script>
</head>

<body>
    <div style="width: 1300px;height: 900px;">
        <div id="main" style="width: 550px;height:400px;float: left"></div>
        <div id="main1" style="width: 550px;height:400px;float: left"></div>
        <div id="main2" style="width: 550px;height:400px;float: left"></div>
        <div id="main3" style="width: 550px;height:400px;float: left"></div>
    </div>


    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById('main'));
        // 显示标题，图例和空的坐标轴
        myChart.setOption({
            title: {
                text: '各种类商品销售额'
            },
            tooltip: {},
            legend: {
                data:['销售额']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '销售额',
                type: 'bar',
                data: []
            }]
        });


        var names=[];    //类别数组（实际用来盛放X轴坐标值）
        var nums=[];    //销量数组（实际用来盛放Y坐标值）

        $.ajax({
            type: "GET",
            url: contextPath+"/SaleBill/getSaleBillByType",
            dataType: "json",
            success: function(result){
                if (result) {
                    for(var i=0;i<result.length;i++){
                        names.push(result[i].typename);    //挨个取出类别并填入类别数组
                    }
                    for(var i=0;i<result.length;i++){
                        nums.push(result[i].sum);    //挨个取出销量并填入销量数组
                    }
                    myChart.hideLoading();    //隐藏加载动画
                    myChart.setOption({        //加载数据图表
                        xAxis: {
                            data: names
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '销售额',
                            data: nums
                        }]
                    });

                }

            }
        });

    </script>
    <script type="text/javascript">
        var myChart1 = echarts.init(document.getElementById('main1'));
        // 显示标题，图例和空的坐标轴
        myChart1.setOption({
            title: {
                text: '各种类商品销量'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: []
            }]
        });


        var names1=[];    //类别数组（实际用来盛放X轴坐标值）
        var nums1=[];    //销量数组（实际用来盛放Y坐标值）

        $.ajax({
            type: "GET",
            url: contextPath+"/SaleBill/getSaleBillByType",
            dataType: "json",
            success: function(result){
                if (result) {
                    for(var i=0;i<result.length;i++){
                        names1.push(result[i].typename);    //挨个取出类别并填入类别数组
                    }
                    for(var i=0;i<result.length;i++){
                        nums1.push(result[i].salenum);    //挨个取出销量并填入销量数组
                    }
                    myChart1.hideLoading();    //隐藏加载动画
                    myChart1.setOption({        //加载数据图表
                        xAxis: {
                            data: names1
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '销量',
                            data: nums1
                        }]
                    });

                }

            }
        });

    </script>
    <script type="text/javascript">
        var myChart2 = echarts.init(document.getElementById('main2'));
        // 显示标题，图例和空的坐标轴
        myChart2.setOption({
            title: {
                text: '近12个月产品销售额'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'line',
                data: []
            }]
        });
        var myChart3 = echarts.init(document.getElementById('main3'));
        // 显示标题，图例和空的坐标轴
        myChart3.setOption({
            title: {
                text: '近12个月产品销量'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'line',
                data: []
            }]
        });


        var names2=[];    //类别数组（实际用来盛放X轴坐标值）
        var nums2=[];    //销量数组（实际用来盛放Y坐标值）
        var names3=[];    //类别数组（实际用来盛放X轴坐标值）
        var nums3=[];    //销量数组（实际用来盛放Y坐标值）

        $.ajax({
            type: "GET",
            url: contextPath+"/SaleBill/getSaleBillByDate",
            dataType: "json",
            success: function(result){
                if (result) {
                    for(var i=0;i<result.length;i++){
                        names2.push(result[i].saledate);    //挨个取出类别并填入类别数组
                    }
                    for(var i=0;i<result.length;i++){
                        nums2.push(result[i].sum);    //挨个取出销量并填入销量数组
                        nums3.push(result[i].salenum);
                    }
                    myChart2.hideLoading();    //隐藏加载动画
                    myChart2.setOption({        //加载数据图表
                        xAxis: {
                            data: names2
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '销量',
                            data: nums2
                        }]
                    });

                    myChart3.hideLoading();    //隐藏加载动画
                    myChart3.setOption({        //加载数据图表
                        xAxis: {
                            data: names2
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '销量',
                            data: nums3
                        }]
                    });

                }

            }
        });

    </script>
   <%-- <script type="text/javascript">
        var myChart1 = echarts.init(document.getElementById('main1'));
        // 显示标题，图例和空的坐标轴
        myChart1.setOption({
            title: {
                text: '各种类商品销量'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: []
            }]
        });


        var names1=[];    //类别数组（实际用来盛放X轴坐标值）
        var nums1=[];    //销量数组（实际用来盛放Y坐标值）

        $.ajax({
            type: "GET",
            url: contextPath+"/SaleBill/getSaleBillByType",
            dataType: "json",
            success: function(result){
                if (result) {
                    for(var i=0;i<result.length;i++){
                        names1.push(result[i].typename);    //挨个取出类别并填入类别数组
                    }
                    for(var i=0;i<result.length;i++){
                        nums1.push(result[i].salenum);    //挨个取出销量并填入销量数组
                    }
                    myChart1.hideLoading();    //隐藏加载动画
                    myChart1.setOption({        //加载数据图表
                        xAxis: {
                            data: names1
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: '销量',
                            data: nums1
                        }]
                    });

                }

            }
        });

    </script>--%>
</body>
</html>
