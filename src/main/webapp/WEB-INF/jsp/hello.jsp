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
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">

<%
    String name= (String) request.getAttribute("name");
%>

<style rel="stylesheet">
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

        </div>

        <div id="main-content">
            <%=name%>
        </div>
    </div>
</div>
</body>
<script rel="script">

</script>
</html>

