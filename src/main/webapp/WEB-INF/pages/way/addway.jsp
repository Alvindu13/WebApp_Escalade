<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'une voie</title>
    <meta charset="utf-8">
    <spring:url value="resources/css/addTopo.css" var="voieStyle" />
    <link href="${voieStyle}" rel="stylesheet" />
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="../_menu.jsp" />
<div class="login-page">
    <div class="form">
        <h4>Veuillez créer votre voie : </h4>
        <form class="login-form" name ="f" action="addway?sectorId=${sectorId}" method='POST' modelAttribute="way">
        <input type='hidden' name = 'sectorId' value = "${sectorId}">
        <input type='text' placeholder='Nom de la voie' name='name'/>
        <input type='text' placeholder='Longueur totale de la voie en mètres' name='totalSize'/>
        <input type='text' placeholder='Nombre de partie/longueur de la voie' name='nbPart'/>
        <input type='text' placeholder='Niveau de la voie (EX : 4A)' name='cotation'/>
        <button  name = "submit" type="submit" class="btn btn-danger">CREER LENGTH</button>
        </form>
    </div>
</div>
<div>
    <jsp:include page="../_footer.jsp" />
</div>
</body>
</html>
