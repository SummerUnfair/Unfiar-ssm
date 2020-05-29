<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>入门程序</h3>
<%--<a href="hello">入门程序</a>--%>
<hr>
<hr>
<hr>
<hr>
<hr>

<%--请求参数绑定--%>
<form action="testRequestBody" method="post" >

    testRequestBody：<input type="text" name="username" /> <br/>
    密码：<input type="text" name="password" /> <br/>
    金额：<input type="text" name="money" /> <br/>
    <input type="submit" value="提交" />

</form>

<hr>
<form action="/item/hello" method="post" >

    姓名：<input type="text" name="username" /> <br/>
    密码：<input type="text" name="password" /> <br/>
    金额：<input type="text" name="money" /> <br/>
    <input type="submit" value="提交" />

</form>

<hr>
<a href="/helloController/testSpring">testSpring</a>
<hr>
<a href="testRequestParam?username=heihei">RequestParam</a>
<a href="testResponseBodyParam?username=heihei">testResponseBodyParam</a>

<hr>
<form action="/item/testModelAttribute" method="post" >

    姓名：<input type="text" name="username" /> <br/>
    密码：<input type="text" name="password" /> <br/>
    金11：<input type="text" name="money" /> <br/>
    <input type="submit" value="提交" />
</form>
</body>
</html>
