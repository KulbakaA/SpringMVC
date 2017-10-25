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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}<c:url value="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script></script>
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
    $(document).ready(function () {
        $('#userName').autocomplete({
            source: function (request, response) {

                $.get('<c:url value="/showUsersFilter?filter=" />' + request.term,function (data) {
                    response($.map(data,function (user, i) {
                        return {value: user.name ,label : user.name + ' ' + user.lastName}
                    }));
                });



                <%--$.ajax({--%>
                    <%--url:'<c:url value="/showUsersFilter" />',--%>
                    <%--data: {--%>
                        <%--filter: request.term--%>
                    <%--},--%>
                    <%--success: function (data) {--%>
                        <%--response($.map(data, function (user, i) {--%>
                            <%--return {value: user.name, label: user.name + ' ' + user.lastName}--%>
                        <%--}));--%>
                    <%--}});--%>


            },
            minLength: 1
        });

    });

</script>


</body>

</html>
