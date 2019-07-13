<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'un site</title>
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
        <form class="login-form" name ="f" action="addsite?topoId=${topo.topoId}" method='POST' modelAttribute="site" enctype="multipart/form-data">
            <div>
                <input type='text' placeholder='Nom du Site' name='name' class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="true"/>
            </div>
            <div>
                <input type='text' placeholder='Ville où se trouve le Site' name='location' class="form-control" id="exampleInputPassword1" required="true"/>
            </div>
            <div>
                <input type='text' placeholder='Difficulté minimum (ex : 4A)' name='cotationMinimum' class="form-control" required="true"/>
            </div>
            <div>
                <input type='text' placeholder='Difficulté maximum (ex : 7B)' name='cotationMaximum' class="form-control" required="true"/>
            </div>
            <div>
                <textarea class="form-control" rows="3" id="comment" placeholder='Description du site' name='comment' required='true' ></textarea>
            </div>
            <input type='hidden' name = 'topoId' value = "${topo.topoId}">
            <br>
            <button  name = "submit" type="submit" class="btn btn-danger">CREER Site</button>
        </form>
    </div>
</div>
<div>
    <jsp:include page="../_footer.jsp" />
</div>
</body>
</html>
