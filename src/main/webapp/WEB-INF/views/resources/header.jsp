<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
<html>
<head>
    <title>Header</title>
</head>
<body>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="#" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="#" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="../index.jsp" class="btn btn--without-border active">Start</a></li>
            <li><a href="../index.jsp#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="../index.jsp#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="../index.jsp#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="../index.jsp#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</body>
</html>
