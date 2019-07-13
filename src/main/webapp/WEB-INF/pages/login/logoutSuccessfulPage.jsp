<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Logout</title>
</head>
<body>
<jsp:include page="../_menu.jsp" />

<h1> <c:out value = "Vous êtes déconnecté !"/> </h1>
</body>
</html>