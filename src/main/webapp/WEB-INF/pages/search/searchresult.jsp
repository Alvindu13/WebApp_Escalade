<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>Résultats</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <style type="text/css">
        body { background-color: #1c7430  ; }
        img { width: 100%; }
        .marge{
            margin-top: 2em;
            margin-bottom: 2em;
        }
        .container{
            background: whitesmoke;
        }
        [class*="col-"]{ text-align: center}
    </style>
</head>

<body>
<jsp:include page="../_menu.jsp" />
<section id = "test" class="row">
    <div class="col-xs-12 col-sm-12 col-md-12"><img src="resources/img/topo/aside.jpg" alt="AsideEscalade"></div>
</section>

<section class="marge">
    <div class ="container">
        <header class="page-header">
            <h1>Voici les résultats de votre recherche</h1>
        </header>

        <c:if test="${empty sites}">
            <h2>Oups.. rien à afficher pour cette recherche</h2>
        </c:if>

        <c:if test="${!empty sites}">
        <div class = "row justify-content-center align-content-center">
            <div class = col-lg-5>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th> Nom du Site </th>
                        <th> Localisation </th>
                        <th> Cotation mini </th>
                        <th> Cotation maxi </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <c:forEach items="${sites}" var="s" varStatus="status">
                    <tr>
                        <td>${s.name}</td>
                        <td>${s.location}</td>
                        <td>${s.cotationMinimum}</td>
                        <td>${s.cotationMaximum}</td>
                    </tr>
                    </c:forEach>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        </c:if>
    </div>
</section>
<div>
    <footer>
        <jsp:include page="../_footer.jsp" />
    </footer>
</div>
</body>
</html>
