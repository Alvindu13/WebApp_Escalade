<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout de secteur </title>
    <meta charset="utf-8">
    <spring:url value="resources/css/addTopo.css" var="topoStyle" />
    <link href="${topoStyle}" rel="stylesheet" />
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="../_menu.jsp" />
<div class="login-page">
    <div class="form">
        <h4>Veuillez renseigner votre Site : </h4>
        <form class="login-form" name ="f" action="addsector?siteId=${siteId}" method='POST' modelAttribute="sector" enctype="multipart/form-data">
            <div>
                <input type='text' placeholder='Nom du secteur' name='name' class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="true"/>
            </div>
            <input type='hidden' name = 'siteId' value = "${siteId}">
            <button  name = "submit" type="submit" class="btn btn-danger">CREER secteur</button>
        </form>
    </div>
</div>
<jsp:include page="../_footer.jsp" />
</body>
</html>
