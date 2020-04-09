<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
<header>
    <jsp:include page="resources/header.jsp"></jsp:include>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="data" method="post" action="/register">
        <div class="form-group">
            <form:input type="email" name="email" placeholder="Email"  path="email"/>
        </div>
        <div class="form-group">
            <form:input type="username" name="username" placeholder="Username"  path="username"/>
        </div>
        <div class="form-group">
            <form:password path="password"/>
        </div>
<%--        <div class="form-group">--%>
<%--            <input type="password" name="password2" placeholder="Powtórz hasło" />--%>
<%--        </div>--%>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<jsp:include page="resources/footer.jsp"></jsp:include>
<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>