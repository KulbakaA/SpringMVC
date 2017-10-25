<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.10.2017
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script ></script>
</head>
<body>
<table style="border: 1px solid black">
    <c:forEach var="user" items="${listOfUsers}">

        <tr>
            <td><a href="<c:url value="/update?id=${user.id}"/>"> ${user.id} </a></td>
            <td><a href="<c:url value="/update?id=${user.id}"/>"> ${user.name} </a></td>
            <td><a href="<c:url value="/update?id=${user.id}"/>"> ${user.lastName} </a></td>
        </tr>

    </c:forEach>
</table>
<div class="ui-widget">
    <input id="userName"/>
</div>

<script>

</script>


</body>

</html>
