<%@ page import="com.escalade.svc.contracts.LengthService" %>
<%@ page import="com.escalade.data.model.Length" %>
<%@ page import="org.springframework.data.domain.Page" %>
<%@ page import="org.springframework.data.domain.Pageable" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>Les voies</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <style type="text/css">
        body { background-color: #1c7430  ; }
        img { width: 100%; }
        .well {
            background-color:#CCC;
            padding: 20px;
        }
        .marge{
            margin-top: 2em;
            margin-bottom: 2em;
        }
        .container{
            background: whitesmoke;
        }

    </style>

</head>

<body>
<jsp:include page="../_menu.jsp" />
<section>
    <div>
        <img class="img-responsive" src="resources/img/topo/aside.jpg" alt="AsideEscalade">
    </div>
</section>
<section class = marge>
    <div class="container rounded border border-dark">
        <div class="text-center">
            <header class="page-header">
                <h2>Voici toutes les voies disponibles et leurs informations pour ce secteur</h2>
            </header>
            <div class="row">
                <div class="col-sm-12">
                    <div class ="row justify-content-center align-content-center">
                        <section class = "col-sm-8 marge">
                            <form class = "well">
                                <h4>Souhaitez-vous ajouter votre propre voie ?</h4>
                                <fieldset>
                                    <a href="${pageContext.request.contextPath}/addway?sectorId=${sectorId}" class="btn btn-primary js-scroll-trigger">Afficher le formulaire</a>
                                </fieldset>
                            </form>
                        </section>
                    </div>
                    <table class="table table-bordered table-striped table-condensed">
                        <thead>
                        <tr>
                            <th>name</th>
                            <th>cotation</th>
                            <th>nb de partie</th>
                            <th>Hauteur de la voie en m</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="i" value="1" />
                        <c:forEach items="${ways}" var="w">
                            <tr>
                                <td> <a class="nav-link" href="${pageContext.request.contextPath}/length?wayId=${w.wayId}"> ${w.name} </td>
                                <td>${w.cotation}</td>
                                <td>${w.nbPart}</td>
                                <td>${w.totalSize}</td>
                            </tr>
                            <c:set var="i" value="${i+1}" />
                        </c:forEach>
                        </tbody>
                    </table>

                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="${currentPageW == 0 ? 'page-item disabled' : 'page-item'}">
                                <a class="page-link" href="${pageContext.request.contextPath}/way?sectorId=${sectorId}&page=${currentPageW-1}" tabindex="-1">Previous</a>
                            </li>
                            <c:set var="k" value="1" />
                            <c:forEach items="${arrayNbPagesW}" var="pageTopo" varStatus="loop">
                                <li class="${currentPageW==loop.index ? 'page-item active' : 'page-item'}">
                                    <a class="page-link" href="${pageContext.request.contextPath}/way?sectorId=${sectorId}&page=${loop.index}">${loop.index}</a>
                                </li>
                                <c:set var="k" value="${k+1}" />
                            </c:forEach>
                            <li class="${currentPageW >= nbPagesW-1 ? 'page-item disabled' : 'page-item'}">
                                <a class="page-link" href="${pageContext.request.contextPath}/way?sectorId=${sectorId}&page=${currentPageW+1}">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</section>

<div>
    <jsp:include page="../_footer.jsp" />
</div>
</body>
</html>

