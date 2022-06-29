<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Affichage</title>
</head>
<body>
<ul>
    <jsp:useBean id="todos" scope="request" type="java.util.List"/>
    <c:forEach var="todo" items="${todos}">
        <li>${todo.sasie}</li>
    </c:forEach>
</ul>
</body>
</html>
