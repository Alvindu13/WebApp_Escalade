<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>Recherche</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style type="text/css">
        body { background-color: #1c7430  ; }
        [class*="col"] { margin-bottom: 20px; }
        img { width: 100%; }
        #link-test{
            color:white;
        }
        #section1{
            background: #9b9b9b;
        }
    </style>

</head>

<body>
<jsp:include page="../_menu.jsp" />
<section id = "test" class="row">
    <div class="col-xs-12 col-sm-12 col-md-12"><img src="resources/img/topo/aside.jpg" alt="AsideEscalade"></div>
</section>
<div class="container">
    <div class="panel-heading">Résultat de la recherche</div>
        <div class="panel-body">
            <table class="table table-bordered table-striped table-condensed">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Localisation</th>
                    </tr>
                </thead>
                <tbody>
                        <c:set var="i" value="1" />
                        <c:forEach items="${sites}" var="s">
                        <tr>
                            <td>${s.name}</td>
                            <td>${s.location}</td>
                        </tr>
                        <c:set var="i" value="${i+1}" />
                        </c:forEach>
                </tbody>
            </table>
            <div>
                <section id = "section1">
                    <ul class = "nav nav-pills">
                        <c:set var="k" value="1" />
                        <c:forEach items="${pages}" var="page" varStatus="loop">
                            <li class="${currentPage==loop.index ? 'nav-link active' : ''}">
                                <a class="nav-link" id = "link-test" href="${pageContext.request.contextPath}/search?motCle=${motCle}&page=${loop.index}">${loop.index}</a>
                            </li>
                            <c:set var="k" value="${k+1}" />
                        </c:forEach>
                    </ul>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
</html>
