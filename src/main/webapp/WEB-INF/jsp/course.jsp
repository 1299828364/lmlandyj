<%--
  Created by IntelliJ IDEA.
  User: 18716
  Date: 2019/6/22
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>

<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.0/dist/bootstrap-table.min.css">
<script src="https://unpkg.com/bootstrap-table@1.15.0/dist/bootstrap-table.min.js"></script>
<body>
<style>
    textarea{
        width: 200px;
        height: 200px;
        white-space: pre-line;
    }
</style>

<table id="ArbetTable"></table>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    标题
                </h4>
            </div>
            <div id="modal-content" class="modal-body">
                <input title="courseNo"  id="course-no" class="show-info" disabled><br/>
                <input title="courseNo" id="course-title" class="show-info"><br/>
                <textarea cols="30" rows="5" title="content" id="course-content" class="show-info"></textarea><br/>
                <input title="courseCreate" id="course-createDate" class="show-info" disabled><br/>
                <input title="courseState" id="state" class="show-info" disabled>
            </div>
            <div class="modal-footer">

                <button id="save-btn" onclick="doAdd()" type="button" class="btn btn-primary">
                    保存
                </button>
                <button id="update-btn" onclick="doUpdate()" type="button" class="btn btn-primary">
                    提交更改
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>
<script rel="script">
    // alert("hello world");

    $(function () {
        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();
    });


    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#ArbetTable').bootstrapTable({
                url: '/api/v1/test1',         //请求后台的URL（*）
                method: 'get',                      //请求方式（*）
                toolbar: '#toolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: false,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                contentType: "application/x-www-form-urlencoded",
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 700,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "no",                     //每一行的唯一标识，一般为主键列
                showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns: [
                    {
                        checkbox: true,
                        visible: true
                    },

                    {
                        field: 'courseTitle',
                        title: '文章标题',
                        width: 300
                    }, {
                        field: 'author',
                        title: '作者',
                        width: 100
                    },{
                        field: 'columnName',
                        title: '栏目名称',
                        width: 200
                    }, {
                        field: 'createDate',
                        title: '创建时间',
                        width: 150
                    }, {
                        field: 'grade',
                        title: '是否置顶',
                        formatter: gradeFormatter
                    }, {
                        field: 'courseNo',
                        title: '操作',
                        formatter: operateFormatter //自定义方法，添加操作按钮
                    }
                ],
                rowStyle: function (row, index) {
                    var classesArr = ['success', 'info'];
                    var strclass = "";
                    if (index % 2 === 0) {//偶数行
                        strclass = classesArr[0];
                    } else {//奇数行
                        strclass = classesArr[1];
                    }
                    return { classes: strclass };
                },//隔行变色
            });

        };


        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset:params.offset
            };
            return temp;
        };
        return oTableInit;
    };

    function gradeFormatter(value) {
        if (value==1){
            return "<span style='text-align: center'>否</sapn>"
        } else {
            return "<span style='text-align: center'>是</sapn>"
        }

    }


    function operateFormatter(value, row, index) {//赋予的参数
        var courseNo=value;
        return [
            '<button class="btn active" onclick="look("'+value+'")">查看</button>',
            '<button class="btn active" onclick="edit("'+value+'")">编辑</button>',
            '<button class="btn btn-default" onclick="remove("'+value+'") href="#">删除</button>'
        ].join('');
    }

    var temp=document.getElementsByClassName("success");
    console.log(temp[0]);
    console.log(temp[0].childNodes[0].tagName);
    console.log(temp[0].childNodes[0]);
    console.log(temp.tagName);
    console.log(temp.children[0].tagName);

    function edit(id) {
        var course=send('get','','api/v1');
        showModal();
        var modalContent=document.getElementById("modal-content");
        putInfo(element);
    }

    function showInfo(id) {

    }

    function remove(id) {

    }

    function look() {

    }

    function putInfo(element) {
        var tr=element.parentNode.parentNode;
        var infos=document.getElementsByClassName("show-info");
        for (var i=0;i<5;i++) {
            if(i==2){
                infos[i].innerText=tr.children[i].children[0].innerHTML;
                continue
            }
            infos[i].value=tr.children[i].innerText;
        }

    }

    function showModal(){
        $('#myModal').modal('show')
    }



    function send(type,data,url,flag){
        alert("开始");
        $.ajax({
            type: type,
            url: url,
            data: {data:data},
            dataType: "json",
            success: function(data){
                // 根据flag判断请求类型若为非1则为请求数据
                if(flag==1){
                    window.location.reload();
                }else {
                    return data;
                }

            },
            error:function (data) {
                console.log(data)
            }
        });

    }

</script>
