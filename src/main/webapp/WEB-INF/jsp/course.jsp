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
        width: 400px;
        height: 400px;
        white-space: pre-line;
    }

    #modal-content input{
        width: 400px;
    }
</style>

<div></div>
<table id="courseTable"></table>


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
                <span>文章标题</span><br>
                <input title="courseTitle"  id="course-title" class="show-info" disabled><br>
                <span>文章作者</span><br>
                <input title="courseAuthor" id="author" class="show-info" disabled><br/>
                <span>文章内容</span><br>
                <textarea cols="30" rows="5" title="content" id="course-content" class="show-info"></textarea><br/>
                <span>创建时间</span><br>
                <input title="courseCreate" id="course-createDate" class="show-info" disabled><br/>
                <span>栏目名称</span><br>
                <input title="courseState" id="column-name" class="show-info" disabled>
            </div>
            <div class="modal-footer">

                <%--<button id="save-btn" onclick="doAdd()" type="button" class="btn btn-primary">--%>
                    <%--保存--%>
                <%--</button>--%>
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

    function init() {
        send('get','','api/v1/courses',2);
        var data=tempData.data;
        var ths=[]
        for (var i = 0;i<data.length;i++){
            ths.push(document.createElement("td"));
        }

    }

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
            '<button class="btn btn-default" onclick="look('+''+value+''+')">查看</button>',
            '<button class="btn btn-default" onclick="edit('+''+value+''+')">编辑</button>',
            '<button class="btn btn-default" onclick="remove('+''+value+''+')" href="#">删除</button>'
        ].join('');
    }
    //
    // var temp=document.getElementsByClassName("success");
    // console.log(temp[0]);
    // console.log(temp[0].childNodes[0].tagName);
    // console.log(temp[0].childNodes[0]);
    // console.log(temp.tagName);
    // console.log(temp.children[0].tagName);

    function edit(id) {
        document.getElementById("course-content").readOnly=false;

        look(id);
        $('#update-btn').toggle();
    }

    function showInfo(data) {
        clearModel();
        "".split();
        document.getElementById("course-title").value=data.courseTitle;
        document.getElementById("author").value=data.author;
        document.getElementById("course-content").innerHTML=data.content;
        document.getElementById("course-createDate").value=data.createDate.split(".")[0];
        document.getElementById("column-name").value=1;
        showModal();
    }

    function remove(id) {

    }

    function clearModel() {
        document.getElementById("course-title").value='';
        document.getElementById("author").value='';
        document.getElementById("course-content").innerHTML='';
        document.getElementById("course-createDate").value='';
        document.getElementById("column-name").value='';
    }

    function look(id) {
        document.getElementById("course-content").readOnly='true';
        $('#update-btn').hide();
        send('get','','api/v1/course/'+id+'',2);
        showInfo(tempData.data);

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

        if (type=='get'){
            $.ajax({
                type: type,
                url: url,
                dataType: "json",
                async:false,
                success: function(data){
                    // 根据flag判断请求类型若为2则为请求数据
                    if(flag==2){
                        console.log(data);
                        tempData=data;
                    }else {
                        window.location.reload();
                    }

                },
                error:function (data) {
                    // console.log(data)
                    console.log('error')
                }
            });

        } else {
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

    }

    var tempData;
</script>
