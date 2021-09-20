<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="main/css/footer.css" rel="stylesheet">
    <link href="main/css/header-auth.css" rel="stylesheet">
    <link href="main/css/global.css" rel="stylesheet">
    <title>Admin</title>
</head>
<body>
<div class="wrapper">
    <%@ include file="/main/pages/comn/header-admin.jsp" %>
    <section class="body">

        <table border="1" width="50%" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Имя</th>

                <th>UPDATE</th>
                <th>DELETE</th>
            </tr>
            <c:forEach items="${allLabels}" var="label">
                <tr>
                    <td><c:out value="${label.getId()}"/></td>
                    <td><c:out value="${label.getName()}"/></td>

                    <td>
                        <a href="${pageContext.request.contextPath}/admin/label/update?id=${label.getId()}"
                           class="header__link">
                            <input type="submit" value="Update"/>
                        </a>
                    </td>
                    <td>
                        <form method="POST"
                              action="${pageContext.request.contextPath}/admin/label/delete?id=${label.getId()}">
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>


        <a href="${pageContext.request.contextPath}/admin/label/add" class="header__link">
            <input type="submit" value="Add"/>
        </a>

    </section>
    <%@ include file="/main/pages/comn/footer.jsp" %>
</div>
</body>
</html>