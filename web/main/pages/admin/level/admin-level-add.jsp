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
        <form action="${pageContext.request.contextPath}/admin/level/add/post" method="POST" class="form sign-in">
            <div class="form__name item">
                <label for="name"><span>Имя</span></label>
                <input class="form__input big" placeholder="Текст" type="text" id="name" name="name" required>
            </div>
            <div class="form__submit item">
                <button class="form__btn green" type="submit" value="login">Добавить</button>
            </div>
        </form>
    </section>

    <%@ include file="/main/pages/comn/footer.jsp" %>
</div>
</body>
</html>