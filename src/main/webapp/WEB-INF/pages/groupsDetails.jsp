<%--
  Created by IntelliJ IDEA.
  User: lukas
  Date: 11.04.2020
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Submission details</title>
    <style>
        table, th, td {
            padding: 2px;
            border: 1px solid black;
        }
    </style>
</head>
<body style="margin: 30px 30px 30px 30px">

<%@include file="../fragments/header.jsp" %>
<h1>${group.name}</h1>
<h2>Users in the group:</h2>
<table>
    <tr>
        <th>Username</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${group.users}" var="user">
        <tr>
            <td>
                <c:out value="${user.username}"/>
            </td>
            <td>
                <a href="/users/${user.id}">Details</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../fragments/footer.jsp" %>

</body>
</html>
