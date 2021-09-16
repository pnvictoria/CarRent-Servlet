<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="main/css/footer.css" rel="stylesheet">
    <link href="main/css/header-auth.css" rel="stylesheet">
    <link href="main/css/global.css" rel="stylesheet">
    <link href="main/css/items.css" rel="stylesheet">
    <link href="main/css/global.css" rel="stylesheet">
    <title>Sign Up</title>
</head>
<body>
<div class="wrapper">
    <%@ include file="/main/pages/comn/header-guest.jsp" %>
    <section class="body">
        <section>
            <div class="container">
                <div class="filter">
                    <div class="filter__wrapper">
                        <div class="filter__params">
                            <input type="text" placeholder="поиск за именем">
                            <div class="select">
                                <select name="" id="">
                                    <option value="">фильтрация за маркой</option>
                                </select>
                            </div>
                            <div class="select">
                                <select name="" id="">
                                    <option value="">фильтрация за качеством</option>
                                </select>
                            </div>
                        </div>
                        <div class="filter__price">
                            <p>Поиск за ценой</p>
                            <div>
                                <input type="text" placeholder="от">
                                <input type="text" placeholder="до">
                            </div>
                        </div>
                    </div>
                    <input type="button" value="Фильтрация">
                </div>
            </div>
        </section>

        <section>
            <div class="items">
                <div class="items__item">
                    <div class="items__img">
                        <img src="${pageContext.request.contextPath}/main/images/oil.png" alt="oil">
                    </div>
                    <div class="items__info">
                        <h3>Lorem ipsum dolor sit amet consectetur </h3>
                        <p><span>Lorem ipsum:</span> test</p>
                        <p><span>Lorem ipsum:</span> test</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
                            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                            exercitation ullamco laboris nisi ut aliquip ex ea commodo sed do eiusmod tempor
                            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                            exercitation ullamco laboris nisi ut aliquip ex ea commodo </p>
                    </div>
                    <div class="items__price">
                        <div>
                            <p><span>450 UAN </span>/ 1h</p>
                        </div>
                        <div>
                            <div class="items__next">
                                <svg width="8" height="11" viewBox="0 0 8 11" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <line x1="1.54344" y1="1.02639" x2="6.71428" y2="6.19723" stroke="white"
                                          stroke-width="2.33947" stroke-linejoin="round"/>
                                    <line x1="6.22117" y1="5.02024" x2="1.54222" y2="9.69919" stroke="white"
                                          stroke-width="2.33947" stroke-linejoin="round"/>
                                </svg>
                            </div>
                            <p>NEXT</p>
                        </div>
                    </div>
                </div>


            </div>
        </section>
    </section>
    <%@ include file="/main/pages/comn/footer.jsp" %>
</div>
</body>
</html>