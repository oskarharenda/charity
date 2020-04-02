<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
<html>
<head>
    <title>test</title>
</head>
<body>
<form:form modelAttribute="donation" method="post" action="/test">
<form:checkboxes path="category"
                 items="${categories}"/>
<form:select path="institution" items="${institutions}"/>
zip code<form:input path="zipCode" />
ulica<form:input path="street" />
miasto<form:input path="city"/>
ilość worków<form:input path="quantity"/>
komentarz<form:textarea path="pickUpComment"/>
data<form:input type="date" path="pickUpDate"/>
czas<form:input type="time" path="pickUpTime" />
    <p><button type="submit">dodaj zlecenie</button> </p>
</form:form>
test
</body>
</html>
