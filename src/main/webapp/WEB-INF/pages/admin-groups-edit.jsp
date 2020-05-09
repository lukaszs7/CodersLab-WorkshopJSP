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
<h1>Edit ${group.name} name</h1>
<form action="/panelAdmin/groups/${group.id}" method="post">
    <input type="text" value="${group.name}" name="groupName"/>
    <input type="submit" value="Edit"/>
</form>

<h2>Remove users from group</h2>

<form action="/panelAdmin/groups/${group.id}" method="post">
    <table>
        <tr>
            <th>User</th>
            <th>Remove from group</th>
        </tr>
        <c:forEach items="${group.users}" var="user">
            <tr>
                <td>
                    <c:out value="${user.username}"/>
                </td>
                <td>
                    <button type="submit" name="removeUserFromGroup" value="${user.id}">Remove user</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

<h2>Add user to group</h2>
<table>
    <tr>
        <th>Username</th>
        <th>User email</th>
    </tr>
    <c:forEach items="${allUsers}" var="user">
        <tr>
            <td>
                <c:out value="${user.username}"/>
            </td>
            <td>
                <c:out value="${user.email}"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="/panelAdmin/groups/${group.id}" method="post">
    <input type="text" placeholder="email" name="addUserToGroup"/>
    <button type="submit">Add user</button>
</form>

<c:if test="${errorMessage != null}">
    <p style="color: red">Cannot perform action, because: '${errorMessage}'</p>
</c:if>
<%@include file="../fragments/footer.jsp" %>

</body>
</html>
