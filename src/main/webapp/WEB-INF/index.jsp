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
<form action="/unfairController/testRequestBody" method="post" >
    RequestBody测试<br/>
    账号：<input type="text" name="username" /> <br/>
    密码：<input type="text" name="password" /> <br/>
    金额：<input type="text" name="money" /> <br/>
    <input type="submit" value="提交" />
</form><hr/>

<%--<a href="hello">入门程序</a>--%>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>
<%
    List list= new ArrayList<>();
    list.add("111");
    list.add("222");
    list.add("333");
    request.setAttribute("list",list);
%>
<c:forEach items="${list}" var="str" varStatus="s">
    ${str}
</c:forEach>
<c:forEach items="${page}" var="str" varStatus="s">
    ${str}
</c:forEach>
<c:if test="false">
    我是真
</c:if>
<%
    request.setAttribute("number",3);
%>
<c:choose>
    <c:when test="${number==1}">星期一</c:when>
    <c:when test="${number==2}">星期二</c:when>
    <c:when test="${number==3}">星期三</c:when>
    <c:when test="${number==4}">星期四</c:when>
    <c:when test="${number==5}">星期五</c:when>
    <c:otherwise>数字有误</c:otherwise>
</c:choose>


<%
    User user = new User();
    user.setUsername("ferao");
    user.setId(2);
    request.setAttribute("u",user);

    List lists = new ArrayList<>();
    lists.add("add");
    lists.add("bbb");
    request.setAttribute("lists",lists);

    Map map = new HashMap<>();
    map.put("name","ferao");
    map.put("gonder","nan");
    request.setAttribute("map",map);
%>
${map}
${requestScope.list}

${requestScope.u}

<%
    request.setAttribute("name","unfair");
    session.setAttribute("age","23");
%>
<h3>El获取值</h3>
${requestScope.name}
${sessionScope.age}

<%!
    static{
        System.out.println("Loading Ferao");
    }
%>

<h3>算数运算符</h3>
${3+4}<br>
${3/4}<br>
${3 div 4}<br>
${3%4}<br>
${3 mod 4}<br>
<h3>比较运算符</h3>
${3==4}<br>
<h3>逻辑运算符</h3>
${3>4 && 3<4 }<br>

<%
    String name="Unfair";
%>
name:<%=name %>
测试热部署<br/>


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

<form action="/item/testModelAttribute" method="post" >

    姓名：<input type="text" name="username" /> <br/>
    密码：<input type="text" name="password" /> <br/>
    金11：<input type="text" name="money" /> <br/>
    <input type="submit" value="提交" />
</form>
</body>
</html>
