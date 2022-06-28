<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.afpa.tptodolist.bo.Todo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Affichage</title>
</head>
<body>
<%
    ArrayList<Todo> todos = (ArrayList<Todo>) request.getAttribute("todos");
%>
<ul>
    <%
        for (Todo todo : todos) {
    %>
    <li>
        <%= todo.getSasie() %>
    </li>
    <%
        }
    %>
</ul>
</body>
</html>
