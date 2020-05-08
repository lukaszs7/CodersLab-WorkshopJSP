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
<h1>Solution details</h1>
<br>
<p>
    <h4>Solution description</h4>
    ${solution.description}
</p>
<p>
    <h4>Exercise title</h4>
    ${solution.exercise.title}
</p>
<p>
    <h4>Exercise description</h4>
    ${solution.exercise.description}
</p>
<p>
    <h4>Solution author</h4>
    ${solution.author.username}
</p>
<p>
    <h4>Solution author</h4>
    ${solution.author.email}
</p>
<p>
    <h4>Solution created at</h4>
    ${solution.createdAt}
</p>
<c:if test="${solution.updatedAt != null}">
    <p>
        <h4>Solution created at</h4>
        ${solution.updatedAt}
    </p>
</c:if>
<%@include file="../fragments/footer.jsp" %>

</body>
</html>
