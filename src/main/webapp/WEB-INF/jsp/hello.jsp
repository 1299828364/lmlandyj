<%--
  Created by IntelliJ IDEA.
  User: 18716
  Date: 2019/6/18
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<%
    String name= (String) request.getAttribute("name");
%>

<style rel="stylesheet">

    .menu{
        width: 100%;
        height: 50px;
        font-size: 20px;
        color: aquamarine;
        padding: auto;
        text-align: center;
    }

    #content{
        width: 100%;
        height: 900px;
        background-color: aquamarine;

    }

    #header{
        width: 100%;
        height: 150px;
        background-color: white;

    }

    #main{
        width: 100%;
        height: 750px;
        border: 1px black solid;
        display: flex;
    }

    #main-aside{
        width: 30%;
        height: 100%;
        background-color: bisque;

    }

    #main-content{
        width: 70%;
        height: 100%;
        background-color: black;

    }
</style>
<body>
<div id="content">
    <div id="header">

    </div>

    <div id="main">
        <div id="main-aside">
            <div class="menu"></div>
        </div>

        <div id="main-content">
            <%=name%>
        </div>
    </div>
</div>
</body>
<script rel="script">
    $.ajax({
        async: false,    //表示请求是否异步处理
        type: "get",    //请求类型
        url: "/API/getmokuai",//请求的 URL地址
        dataType: "json",//返回的数据类型
        success: function (data) {
            console.log(data.list);  //在控制台打印服务器端返回的数据
            var eles=[];

            var names=data.name;
            var op=data.op;
            for (var i = 0; i < data.name.length; i++) {
                var ele="<div class='menu'>"+data.list[i]+"</div>";
                eles.push(ele);
            }

            var res='<div>';
            for (var i = 0; i < data.list.length; i++) {
                res+=eles[i];
            }
            res+='</div>';


            document.getElementById("main-aside").innerHTML=res;



            // for (var i = 0; i < data.length; i++) {
            //     console.log(data)
            // }
            // $("select[name='depertmentId']").empty();
            // $("select[name='depertmentId']").append('<option value="">——请选择——</option>');
            // for(var i=0;i<data.length;i++){
            //     var html ='<option value="'+data[i].deptId+'">';
            //     html +=data[i].deptName + '</option>';
            //     $("select[name='departmentId']").append(html);  //将数据显示在html页面
            // }
        },
        error: function (data) {
            alert(data.result);
        }
    })
</script>
</html>

