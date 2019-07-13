<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout de topo</title>
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
            <h4>Veuillez créer votre TOPO : </h4>
            <form class="login-form" name ="f" action="addtopo" method='POST' modelAttribute="topo" />
                <input type="text" readonly class="form-control-plaintext" id="staticUser" value="${pageContext.request.userPrincipal.name}"/>
                <input type='text' placeholder='Nom du Topo' name='name' required="true"/>
                <input type='hidden' name = 'available' value = "${false}">
                <input type='hidden' name = 'reserve' value = "${false}">
                <input type='hidden' name = 'userEscalad.userEscaladId' value = "${currentUser.userEscaladId}">
                <button  name = "submit" type="submit" class="btn btn-danger">CREER TOPO</button>
            </form>
        </div>
    </div>
<div>
    <jsp:include page="../_footer.jsp" />
</div>
</body>
</html>
