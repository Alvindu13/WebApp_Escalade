<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <spring:url value="resources/css/bootstrap.min.css" var="bootstrap" />
    <spring:url value="resources/css/all.min.css" var="all" />
    <spring:url value="resources/css/grayscale.min.css" var="grayscale" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>HomePage</title>
    <!-- Bootstrap core CSS
    <link href="${bootstrap}" rel="stylesheet" />-->
    <!-- Custom fonts for this template -->
    <link href="${all}" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- Custom styles for this template -->
    <link href="${grayscale}" rel="stylesheet" />

</head>

<body id="page-top">
<jsp:include page="_menu.jsp" />
<!-- Header -->
<header class="masthead">
    <div class="container d-flex h-100 align-items-center">
        <div class="mx-auto text-center">
            <h1 class="mx-auto my-0 text-uppercase">GRAYSCALAD</h1>
            <h2 class="text-white-50 mx-auto mt-2 mb-5">Le site des grimpeurs chevronnés.</h2>
            <a href="${pageContext.request.contextPath}/topo?user=${pageContext.request.userPrincipal.name}" class="btn btn-primary js-scroll-trigger">Découvrir les TOPOS</a>
        </div>
    </div>
</header>
<jsp:include page="_footer.jsp" />
<!-- Bootstrap core JavaScript -->
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="resources/js/jquery.easing.min.js"></script>

<!-- Custom scripts for this template -->
<script src="resources/js/grayscale.min.js"></script>
</body>
</html>
