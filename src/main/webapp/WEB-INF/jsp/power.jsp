<%--
  Created by IntelliJ IDEA.
  User: 18716
  Date: 2019/6/25
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<style rel="stylesheet">
    #main{
        display: flex;
        width: 100%;
        height: 800px;
    }

    #left{
        height: 100%;
        width: 40%;
        background-color: aquamarine;
    }

    #right{
        height: 100%;
        width: 50%;
        background-color: aqua;
    }

    li{
     cursor: pointer;
    }

</style>

<div id="main">
    <div id="left">


        <ul id='two'>
            <li id='prent2'>
                <a class='' data-toggle='collapse' data-percent='prent2' href='#prent2_child'><span class="glyphicon glyphicon-home"style="margin-right: 10px;"></span>全部角色</a>
                <ul class='collapse' id='prent2_child'>
                </ul>
        </ul>
        </li>
        </ul>
    </div>

    <div id="right">
        <ul id='one'>
            <li id='prent1'>
                <a class='' data-toggle='collapse' data-percent='prent1' href='#prent1_child'><span class="glyphicon glyphicon-home"style="margin-right: 10px;"></span>全部模块</a>
                <ul class='collapse' id='prent1_child'>
                    <input type="checkbox"/><li  data-toggle='collapse' data-percent='prent2_1_child' href='#prent2_1_1_child'>系统设置</li>
                    <ul class='collapse' id='prent2_1_1_child'>
                        <li><input class="power" onclick="setPower(9)" id="p9" type="checkbox"/>码表管理</li>
                        <li><input class="power" onclick="setPower(10)" id="p10" type="checkbox"/>首页信息设置</li>
                        <li><input class="power" onclick="setPower(11)" id="p11" type="checkbox"/>默认功能设置</li>
                        <li><input class="power" onclick="setPower(12)" id="p12" type="checkbox"/>角色管理</li>
                        <li><input class="power" onclick="setPower(2)" id="p2" type="checkbox"/>人员管理</li>
                        <li><input class="power" onclick="setPower(3)" id="p3" type="checkbox"/>角色分配</li>
                        <li><input class="power" onclick="setPower(4)" id="p4" type="checkbox"/>模块管理</li>
                        <li><input class="power" onclick="setPower(5)" id="p5" type="checkbox"/>权限管理</li>
                    </ul>



                    <input type="checkbox"/><li data-toggle='collapse' data-percent='prent2_2_child' href='#prent2_2_1_child'>网站内容管理</li>
                    <ul class='collapse' id='prent2_2_1_child'>
                        <li><input class="power" onclick="setPower(6)" id="p6" type="checkbox"/>栏目管理</li>
                        <li><input class="power" onclick="setPower(7)" id="p7" type="checkbox"/>审查文章</li>
                        <li><input class="power" onclick="setPower(1)" id="p1" type="checkbox"/>文章管理</li>
                        <li><input class="power" onclick="setPower(8)" id="p8" type="checkbox"/>留言管理</li>
                    </ul>
                </ul>
        </ul>
        </li>
        </ul>
    </div>

</div>






</body>

<script type="text/javascript">


    getRoles()
    function getRoles() {
        send('get','','/api/v1/roles',2);
        var data=tempData.data;
        var rolesPane=document.getElementById("prent2_child");
        var lis='';
        for (var i = 0 ;i<data.length;i++){
            lis+="<li onclick='getPower("+data[i].roleNo+")' data-toggle='collapse' data-percent='prent2_2_child'> <span class=\"glyphicon glyphicon-user \"></span>"+data[i].roleName+"</li>\n"
        }
        rolesPane.innerHTML=lis;

    }

    function setPower(powerNo) {
        send('put',{"roleNo":nowRole,"powerNo":powerNo},'/api/v1/powerAndRole')
    }

    function getPower(roleNo) {
        nowRole=roleNo;
        var checks=document.getElementsByClassName("power");
        for (var i = 0;i<checks.length;i++){
            checks[i].checked=false;
        }

        $(".collapse").collapse();
        send('get','','/api/v1/powers/'+roleNo,2);
        var data=tempData.data;

        var powerNos=[];
        for (var i = 1;i<data.length;i++){
          powerNos.push('p'+data[i].powerNo) ;
        }

        for (var i = 1;i<powerNos.length;i++) {
            console.log(powerNos[i])
            document.getElementById(powerNos[i]).checked=true;
        }

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
                data:JSON.stringify(data) ,
                dataType: "application/json",
                contentType: "application/json;charset=UTF-8",
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

    var nowRole;
    var tempData;
</script>
</html>
