<%@ page import="entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/header-auth.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/user-page.css">
    <title>User page</title>
</head>
<body>
<div class="wrapper">
    <%@ include file="/main/pages/comn/header-user.jsp" %>
    <section class="body">
        <div class="container">
            <div class="about">
                <div class="about__wrapper">
                    <%if (userObj.getAvatar() == null || userObj.getAvatar().isEmpty()) {%>
                    <img src="${pageContext.request.contextPath}/main/images/avatar.png" alt="avatar"
                         class="about__avatar">
                    <%} else {%>
                    <img src="${pageContext.request.contextPath}/main/upload/${user.getAvatar()}" alt="avatar"
                         class="about__avatar" width="250" height="250">
                    <%}%>
                    <div class="about__info">
                        <h1>${user.getName()} ${user.getSurname()}</h1>
                        <p>Украина, соискатель</p>
                    </div>
                </div>
            </div>
            <div class="setting">
                <div class="setting__wrapper">
                    <h2>Настройки</h2>
                    <div class="setting__images" hidden>
                        <div class="setting__img-info">
                            <%if (userObj.getAvatar() == null || userObj.getAvatar().isEmpty()) {%>
                            <img src="${pageContext.request.contextPath}/main/images/avatar.png" alt="avatar"
                                 class="about__avatar">
                            <%} else {%>
                            <img src="${pageContext.request.contextPath}/main/upload/${user.getAvatar()}" alt="avatar"
                                 class="about__avatar" width="250" height="250">
                            <%}%>
                            <p>./avatar.jpg</p>
                        </div>
                        <span>Изменить</span>
                    </div>
                    <div class="setting__info">
                        <div class="setting__item">
                            <p>Имя</p>
                            <p>${user.getName()} ${user.getSurname()}</p>
                            <span>Изменить</span>
                        </div>
                        <div class="setting__item">
                            <p>Почта</p>
                            <p>${user.getEmail()}</p>
                            <span>Изменить</span>
                        </div>
                        <div class="setting__item">
                            <p>Фото</p>
                            <form action="${pageContext.request.contextPath}/upload/post" method="post" class="user_photo"
                                  enctype="multipart/form-data">
                                <input type="file" name="file"/>
                                <input type="submit" value="Upload"/>
                            </form>
                        </div>
                    </div>
                    <div class="setting__discard">
                        <p><a href="#">Удалить аккаунт</a></p>
                        <a href="${pageContext.request.contextPath}/sign-out">
                            <div class="setting__exit">
                                <svg width="15" height="14" viewBox="0 0 15 14" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path d="M12.4836 0.709229H6.76929C6.23903 0.709796 5.73065 0.920692 5.3557 1.29564C4.98075 1.67059 4.76985 2.17897 4.76929 2.70923V6.42351H10.2468L8.36536 4.54173C8.26272 4.43369 8.20634 4.28983 8.20825 4.14083C8.21016 3.99182 8.2702 3.84946 8.37557 3.74408C8.48094 3.63871 8.62331 3.57867 8.77231 3.57676C8.92132 3.57485 9.06518 3.63123 9.17321 3.73387L12.0304 6.59101C12.1374 6.69816 12.1976 6.84345 12.1976 6.99494C12.1976 7.14643 12.1374 7.29172 12.0304 7.39887L9.17321 10.256C9.06518 10.3587 8.92132 10.415 8.77231 10.4131C8.62331 10.4112 8.48094 10.3512 8.37557 10.2458C8.2702 10.1404 8.21016 9.99806 8.20825 9.84905C8.20634 9.70005 8.26272 9.55619 8.36536 9.44815L10.2468 7.56637H4.76929V11.2807C4.76929 12.4253 5.97607 13.2807 7.055 13.2807H12.4836C13.0138 13.2801 13.5222 13.0692 13.8972 12.6942C14.2721 12.3193 14.483 11.8109 14.4836 11.2807V2.70923C14.483 2.17897 14.2721 1.67059 13.8972 1.29564C13.5222 0.920692 13.0138 0.709796 12.4836 0.709229Z"
                                          fill="#0DA1A1"></path>
                                    <path d="M1.34096 6.4231C1.18941 6.4231 1.04406 6.4833 0.936899 6.59046C0.829735 6.69763 0.769531 6.84297 0.769531 6.99452C0.769531 7.14608 0.829735 7.29142 0.936899 7.39859C1.04406 7.50575 1.18941 7.56595 1.34096 7.56595H4.76953V6.4231H1.34096Z"
                                          fill="#0DA1A1"></path>
                                </svg>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%@ include file="/main/pages/comn/footer-user.jsp" %>
</div>
</body>
</html>