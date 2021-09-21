<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/admin-page.css">
    <title>Admin</title>
</head>
<body>
<div class="wrapper">
    <%@ include file="/main/pages/comn/header-admin.jsp" %>
    <section class="body">

        <table border="1" width="80%" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Пол</th>
                <th>Дата Рождение</th>
                <th>Почта</th>
                <th>Роль</th>

                <th>UPDATE</th>
                <th>DELETE</th>
            </tr>
            <c:forEach items="${allUsers}" var="user">
                <tr>
                    <td><c:out value="${user.getId()}"/></td>
                    <td><c:out value="${user.getName()}"/></td>
                    <td><c:out value="${user.getSurname()}"/></td>
                    <td><c:out value="${user.isSex()}"/></td>
                    <td><c:out value="${user.getDate()}"/></td>
                    <td><c:out value="${user.getEmail()}"/></td>
                    <td><c:out value="${user.getRole().getName()}"/></td>
                    <td>
                        <form method="POST"
                              action="${pageContext.request.contextPath}/admin/user/update?id=${user.getId()}">
                            <input type="submit" value="Update"/>
                        </form>
                    </td>
                    <td>
                        <form method="POST"
                              action="${pageContext.request.contextPath}/admin/user/delete?id=${user.getId()}">
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <form method="POST" action="${pageContext.request.contextPath}/admin/user/add}">
            <input type="submit" value="Add"/>
        </form>

    </section>
    <%@ include file="/main/pages/comn/footer.jsp" %>
</div>
</body>
</html>