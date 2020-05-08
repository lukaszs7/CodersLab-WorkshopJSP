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
    <title>Index html</title>
    <style>
        table, th, td {
            padding: 2px;
            border: 1px solid black;
        }
    </style>
</head>
<body style="margin: 30px 30px 30px 30px">

<%@include file="../fragments/header.jsp" %>
<h1>Available groups</h1>
<table>
    <tr>
        <th>Group name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>
                <c:out value="${group.name}"/>
            </td>
            <td>
                <a href="/groups/${group.id}">Details</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../fragments/footer.jsp" %>

</body>
</html>
