<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car-Rent</title>
</head>

<body>


<form action="${pageContext.request.contextPath}/login" method="POST" class="form sign-in">
    <div class="form__mail item">
        <label for="email"><span>Электронная почта</span></label>
        <input class="form__input big" placeholder="Текст" type="text" name="email" id="email">
    </div>
    <div class="form__pswd item">
        <label for="password"><span>Пароль</span></label>
        <input class="form__input big" placeholder="Текст" type="password" name="password" id="password">
    </div>
    <div class="form__submit item">
        <button class="form__btn green" type="submit">Войти</button>
    </div>
</form>


</body>
</html>
