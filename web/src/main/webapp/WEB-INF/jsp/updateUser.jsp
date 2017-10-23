<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.10.2017
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

<form action="<c:url value="/doUpdate"/>" id="formForUpdate" method="post">
    <input id="id" name="id" type="hidden" value="${userById.id}"><br/>
    <label for="name">Enter the new name for:<input id="name" name="name" type="text" value="${userById.name}"></label><br/>
    <label for="lastName">Enter the new last name for:<input id="lastName" name="lastName" type="text" value="${userById.lastName}"></label><br/>
    <input type="submit" name="save" value="Click!">
</form>

</body>
</html>
