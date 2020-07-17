<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.unfair.api.vo.UserVO" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>欢迎回家</title>
</head>
<body>

<h3>ヽ(✿ﾟ▽ﾟ)ノ 欢迎回家</h3>

<a href="/unfairHome/JsonStyle" target="_self">
    <input type="button" name="unfairButton" value="Json是这个样子的" />
</a>

<h4>全员信息</h4>

<c:forEach items="${userVO}" var="userMessage" >
    ${userMessage.id}
    ${userMessage.username}
    ${userMessage.create_time}
    ${userMessage.update_time}<br>
</c:forEach>
<h4>日期时间</h4>
<%
    request.setAttribute("number",3);
%>
<c:choose>
    <c:when test="${weekNumber==1}">星期一</c:when>
    <c:when test="${weekNumber==2}">星期二</c:when>
    <c:when test="${weekNumber==3}">星期三</c:when>
    <c:when test="${weekNumber==4}">星期四</c:when>
    <c:when test="${weekNumber==5}">星期五</c:when>
    <c:when test="${weekNumber==6}">星期六</c:when>
    <c:when test="${weekNumber==7}">星期天</c:when>
    <c:otherwise>数字有误</c:otherwise>
</c:choose>
<br>

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
    UserVO userVO = new UserVO();
    userVO.setUsername("ferao");
    userVO.setId(2);
    request.setAttribute("u", userVO);

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
