<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>RestFul</h3>
success

<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>

<%
    request.setAttribute("number",3);
%>
</body>
</html>