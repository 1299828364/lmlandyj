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
<script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
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

    .col-sm-6{
        width: 30%;
    }

    #control{
        width: 20%;
    }

    #search-input{
        width: 20%;
    }

    /*#data{*/
    /*width: 600px;*/
    /*}*/

</style>

<%--<input type="button" value="新增" onclick="add()" id="add">--%>
<%--<input type="button" value="删除" onclick="remove()" id="delete">--%>

<div class="row" id="data">

    <div id="search-input" class='col-sm-6'>
        <div class="form-group">
            <label>请输入文章标题</label>
            <div class='input-group date'>
                <input id="search-title" class="form-control" type="text" >
            </div>

        </div>
    </div>
    <div class='col-sm-6'>
        <div class="form-group">
            <label>选择开始时间：</label>
            <!--指定 date标记-->
            <div class='input-group date' id='datetimepicker1'>
                <input type='text' id="start-time" class="form-control" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
        </div>
    </div>
    <div class='col-sm-6'>
        <div class="form-group">
            <label>选择结束时间：</label>
            <!--指定 date标记-->
            <div class='input-group date' id='datetimepicker2'>
                <input type='text' id="end-time" class="form-control" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
        </div>
    </div>


    <div id="control" class='col-sm-6'>
        <div class="form-group">
            <label>&nbsp;</label>
            <div class='input-group date'>
                <input type="button" onclick="doSearch()" value="搜索">
                <input type="button" value="删除">
            </div>
        </div>
    </div>


</div>

<table class="table table-hover table-striped" id="courseTable">
    <thead>
    <th><input type="checkbox" onclick="allCheck()" id="rem-all"></th>
    <th>文章标题</th>
    <th>作者</th>
    <th>栏目名称</th>
    <th>创建时间</th>
    <th>操作</th>
    </thead>
    <tbody id="tbody">

    </tbody>
</table>
<p>
    <span>当前页数:</span>
    <span id="page"></span>
    <span><input type="button" onclick="nextPage()" value="下一页"></span>
    <span><input type="button" onclick="lastPage()" value="上一页"></span>
</p>


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

    var selectCourse;
    var nowPage=0;
    var searchPage=0;
    var initUrl='api/v1/courseWithColumnName/';
    var searchUrl='/api/v1/courseWithPage/';
    var url=initUrl;
    var page=0;
    var isSearch=false;
    var courseNos=[];
    start();


    function doUpdate() {
        var content=$("#course-content").val();
        selectCourse[content]=content;
        send('post',selectCourse,'/api/v1/courses',2);
        closeModal();
    }


    function allCheck() {

        var allcheck=document.getElementById("rem-all");
        var checks=document.getElementsByClassName("rem");
        if(allcheck.checked){
            for(var i=0;i<checks.length;i+=1){
                checks[i].checked=true;
            }
        }else {
            for(var i=0;i<checks.length;i+=1){
                checks[i].checked=false;
            }
        }

    }

    function nextPage() {
        page++;
        send('get','',url+page,2);
        var data=tempData.data;
        if(data.length==0){
            page--;

        }
        start()
    }

    function lastPage() {
        var url='';
        if(isSearch){
            url=searchUrl;
        }else {
            url=initUrl;
        }
        if (page!=0){
            page--;
            start();
        }else {
            alert("没有上一页了");
        }
    }

    function start() {
        var url='';
        if(isSearch){
            url=searchUrl;
        }else {
            url=initUrl;
        }
        send('get','',url+''+page,2);
        var data=tempData.data;
        init(data);
    }


    function doSearch() {

        var endTime=$("#end-time").val();
        var startTime=$("#start-time").val();
        var title=$("#search-title").val();
        alert(endTime+"<"+startTime);
        page=searchPage;
        send("get",{"start":startTime,"end":endTime,"title":title+""},searchUrl+page,2);
        init(tempData.data);

    }

    function edit(id) {
        document.getElementById("course-content").readOnly=false;

        look(id);
        $('#update-btn').toggle();
    }

    function showInfo(data) {
        console.log(data);
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
        send("delete",'',"/api/v1/courses/"+id,2);
        start();
    }

    function clearModel() {
        document.getElementById("course-title").value='';
        document.getElementById("author").value='';
        document.getElementById("course-content").innerHTML='';
        document.getElementById("course-createDate").value='';
        document.getElementById("column-name").value='';
    }

    function look(id) {

        // document.getElementById("course-content").readOnly='true';
        $('#update-btn').hide();
        send('get','','api/v1/course/'+id+'',2);
        showInfo(tempData.data);
        selectCourse=tempData.data;

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

    function closeModal() {
        $('#myModal').modal('hide');
    }


    function send(type,data,url,flag){

        if (type=='get'){
            $.ajax({
                type: type,
                url: url,
                data: data,
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
                data:JSON.stringify(data) ,
                dataType: "application/json",
                contentType: "application/json;charset=UTF-8",
                async:false,
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
    $(function () {
        var picker1 = $('#datetimepicker1').datetimepicker({
            format: 'YYYY/MM/DD',
            locale: moment.locale('zh-cn'),

            //minDate: '2016-7-1',

        });
        var picker2 = $('#datetimepicker2').datetimepicker({
            format: 'YYYY/MM/DD',
            locale: moment.locale('zh-cn')
        });
        //动态设置最小值
        picker1.on('dp.change', function (e) {
            picker2.data('DateTimePicker').minDate(e.date);
        });
        //动态设置最大值
        picker2.on('dp.change', function (e) {
            picker1.data('DateTimePicker').maxDate(e.date);
        });
    });

    function init(data) {

        var tbody=document.getElementById("tbody");

        // var childs=tbody.childNodes;
        // for (var k=childs.length-1;k>=0;k--){
        //     tbody.removeChild(childs[i]);
        // }

        courseNos=[];
        $("#tbody").empty();
        for (var i = 0;i<data.length;i++){
            courseNos.push(data['courseNo']);
            var tr=document.createElement("tr");

            var checkbox=document.createElement("td");
            checkbox.innerHTML="<input class='rem' type='checkbox' id='rem'/>"
            tr.appendChild(checkbox);
            var td1=document.createElement("td");
            var td2=document.createElement("td");
            var td3=document.createElement("td");
            var td4=document.createElement("td");
            var td5=document.createElement("td");
            td1.innerText=data[i]['courseTitle'];
            td2.innerText=data[i]['author'];
            td3.innerText=data[i]['columnName'];
            td4.innerText=data[i]['createDate'];
            td5.innerHTML="<input type='button' onclick='remove("+data[i]['courseNo']+")' value='删除'/> <input type='button' onclick='edit("+data[i]['courseNo']+")' value='修改'/>";
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tr.appendChild(td5);

            tbody.appendChild(tr);
        }
    }

    var tempData;
</script>
