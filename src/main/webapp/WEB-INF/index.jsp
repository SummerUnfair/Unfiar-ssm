<%@ page import="com.unfair.pojo.User" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>unfair-ssm</title>
    <script type="text/javascript" src="webjars/jquery/jquery.js" ></script>
    <script type="text/javascript">
        //alert('hello.world');
        console.log('ferao jsp 页面');
    </script>
</head>
<body>

<h3>unfair|首页</h3><hr/>
<%--请求参数绑定--%>
<form action="/unfairHome/Login" method="post" >
    用户登陆--><br/>
    账号：<input type="text" name="username" /> <br/>
    密码：<input type="text" name="password" /> <br/>
    金额：<input type="text" name="money" /> <br/>
    <input type="submit" value="提交" />
</form><hr/>

<%--<a href="hello">入门程序</a>--%>

</body>
</html>
