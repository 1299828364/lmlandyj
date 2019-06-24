<%--
  Created by IntelliJ IDEA.
  User: 18716
  Date: 2019/6/22
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

    <body>
    <script rel="script">
        // $.ajax({
        //     async: false,    //表示请求是否异步处理
        //     type: "get",    //请求类型
        //     url: "/API/getmokuai",//请求的 URL地址
        //     dataType: "json",//返回的数据类型
        //     success: function (data) {
        //         console.log(data.list);  //在控制台打印服务器端返回的数据
        //         var eles=[];

        //         var names=data.name;
        //         var op=data.op;
        //         for (var i = 0; i < data.name.length; i++) {
        //             var ele="<div class='menu'>"+data.list[i]+"</div>";
        //             eles.push(ele);
        //         }

        //         var res='<div>';
        //         for (var i = 0; i < data.list.length; i++) {
        //             res+=eles[i];
        //         }
        //         res+='</div>';


        //         document.getElementById("main-aside").innerHTML=res;



        //         // for (var i = 0; i < data.length; i++) {
        //         //     console.log(data)
        //         // }
        //         // $("select[name='depertmentId']").empty();
        //         // $("select[name='depertmentId']").append('<option value="">——请选择——</option>');
        //         // for(var i=0;i<data.length;i++){
        //         //     var html ='<option value="'+data[i].deptId+'">';
        //         //     html +=data[i].deptName + '</option>';
        //         //     $("select[name='departmentId']").append(html);  //将数据显示在html页面
        //         // }
        //     },
        //     error: function (data) {
        //         alert(data.result);
        //     }
        // })

        $(".nav li").click(function() {
            $(".active").removeClass('active');
            $(this).addClass("active");
        });
    </script>

    <!--顶部导航栏部分-->
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" title="logoTitle" href="#">Neo Yang</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li role="presentation">
                        <a href="#">当前用户：<span class="badge">TestUser</span></a>
                    </li>
                    <li>
                        <a href="../login/logout">
                            <span class="glyphicon glyphicon-lock"></span>退出登录</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- 中间主体内容部分 -->
    <div class="pageContainer">
        <!-- 左侧导航栏 -->
        <div class="pageSidebar">
            <ul class="nav nav-stacked nav-pills">
                <li role="presentation">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">网页内容操作</a></h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="/course" target="mainFrame">留言管理</a></li>
                                    <li><a href="course.jsp" target="mainFrame">文章管理</a></li>
                                    <li><a href="ghsgl.aspx" target="mainFrame">审核文章</a></li>
                                    <li><a href="ghsgl.aspx" target="mainFrame">栏目管理</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="dropdown">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">系统设置</a></h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul class="nav nav-pills nav-stacked">
                                    <li><a href="jgdx1.aspx" target="mainFrame">权限管理</a></li>
                                    <li><a href="ghsgl.aspx" target="mainFrame">模块管理</a></li>
                                    <li><a href="ghsgl.aspx" target="mainFrame">角色分配</a></li>
                                    <li><a href="ghsgl.aspx" target="mainFrame">人员管理</a></li>
                                    <li><a href="ghsgl.aspx" target="mainFrame">角色管理</a></li>
                                    <li><a href="ghsgl.aspx" target="mainFrame">默认功能设置</a></li>
                                    <li><a href="ghsgl.aspx" target="mainFrame">首页信息设置</a></li>
                                    <li><a href="ghsgl.aspx" target="mainFrame">码表管理</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <!-- 左侧导航和正文内容的分隔线 -->
        <div class="splitter"></div>
        <!-- 正文内容部分 -->
        <div class="pageContent">
            <iframe src="index.html" id="mainFrame" name="mainFrame" frameborder="0" width="100%" height="100%" frameBorder="0"></iframe>
        </div>
    </div>
    <!-- 底部页脚部分 -->
    <div class="footer">
        <p class="text-center">
            2019 &copy; lml.
        </p>
    </div>
    <style rel="stylesheet">
        .navbar-collapse {
            padding-left: 5px;
            padding-right: 5px;
        }

        .nav>li {
            text-align: center;
        }

        .nav>li>a {
            color: #444;
            margin: 0 5px;
        }

        .nav-pills>li.active>a,
        .nav-pills>li.active>a:focus,
        .nav-pills>li.active>a:hover {
            background-color: #222222;
        }

        .dropdown-menu {
            min-width: 200px;
            margin-left: 40px;
            background-color: #E3E3E3;
        }

        .dropdown-menu>li>a {
            padding: 10px 15px;
        }

        body {
            width: 100%;
            height: 100%;
            margin: 0;
            overflow: hidden;
            background-color: #FFFFFF;
            font-family: "Microsoft YaHei", sans-serif;
        }

        .pageSidebar {
            width: 240px;
            height: 100%;
            padding-bottom: 30px;
            overflow: auto;
            background-color: #e3e3e3;
        }

        .splitter {
            width: 5px;
            height: 100%;
            bottom: 0;
            left: 240px;
            position: absolute;
            overflow: hidden;
            background-color: #fff;
        }

        .pageContent {
            height: 100%;
            min-width: 768px;
            left: 246px;
            top: 0;
            right: 0;
            z-index: 3;
            padding-bottom: 30px;
            position: absolute;
        }

        .pageContainer {
            bottom: 0;
            left: 0;
            right: 0;
            top: 53px;
            overflow: auto;
            position: absolute;
            width: 100%;
        }

        .footer {
            width: 100%;
            height: 30px;
            line-height: 30px;
            margin-top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            position: absolute;
            z-index: 10;
            background-color: #DFDFDF;
        }
    </style>
    </body>

</html>
