<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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

        <table border="1" width="80%" cellpadding="5">
            <c:forEach items="${allCars}" var="car">
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Цена за час</th>
                    <th>Фото</th>
                    <th>Описание</th>
                    <th>Марка</th>
                    <th>Качество</th>

                    <th>UPDATE</th>
                    <th>DELETE</th>
                </tr>
                <tr>
                    <td><c:out value="${car.getId()}"/></td>
                    <td><c:out value="${car.getName()}"/></td>
                    <td><c:out value="${car.getPrice()}"/></td>
                    <td><c:out value="${car.getJpg()}"/></td>
                    <td><c:out value="${car.getDesc()}"/></td>
                    <td><c:out value="${car.getLabel().getName()}"/></td>
                    <td><c:out value="${car.getLevel().getName()}"/></td>

                    <td>
                        <form method="POST" action="${pageContext.request.contextPath}/admin/update?carId=${car.getId()}">
                            <input type="submit" value="Update"/>
                        </form>
                    </td>
                    <td>
                        <form method="POST" action="${pageContext.request.contextPath}/admin/delete?carId=${car.getId()}">
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>


    </section>
    <%@ include file="/main/pages/comn/footer.jsp" %>
</div>
</body>
</html>