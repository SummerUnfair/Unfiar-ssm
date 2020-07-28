<%@ page import="com.unfair.api.vo.UserVO" %>
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
    <link rel="stylesheet" href="\css\common.css" />
    <script type="text/javascript">
        //alert('hello.world');
        console.log('ferao jsp 页面');
    </script>
</head>
<body>

<h3 class="subTitle">unfair|首页</h3><hr/>
<%--请求参数绑定--%>
<form action="/unfairHome/Login" method="post" class="subForm" >
    用户登陆<br/>
    <label for="username">账号：</label><input type="text" name="username" id="username"  placeholder="最长六位数字" size="20" maxlength="6" /> <br/>
    <label for="password">密码：</label><input type="text" name="password" id="password" placeholder="最长六位数字" size="20" maxlength="6" /> <br/>
    <label for="retry">重置：</label><input type="text" name="retry" id="retry" placeholder="最长六位数字" size="20" maxlength="6" /> <br/>
    <input type="reset" value="清空" />
    <input type="submit" value="提交" />
</form>
<br/><a href="https://blog.csdn.net/qq_21561501" target="_self"><br/>&copy;版权所有ferao</a>
<%--<a href="hello">入门程序</a>--%>
</body>
</html>
