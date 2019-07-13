<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML>
<html>

<head>
    <title>Réservation</title>
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
        [class*="col-"]{ text-align: center}
    </style>
</head>


<body>

<jsp:include page="../_menu.jsp" />

<section>
    <div>
        <img class="img-responsive" src="resources/img/topo/aside.jpg" alt="AsideEscalade">
    </div>
</section>

<section class = "marge align-content-center">
    <div class="container rounded border border-dark text-center">
        <div class="text-center">
            <header class="page-header">
                <h1>Bonjour ${pageContext.request.userPrincipal.name}, vous trouverez sur cette les topos disponibles pour la réservation</h1>
            </header>
            <div class = "row align-items-center row justify-content-center">
                <div class = "col-lg-10" >
                    <div class="panel-body">
                        <table class="table table-bordered table-striped table-condensed text-center">
                            <thead class="thead-dark">
                            <tr>
                                <th> Nom du topo</th>
                                <th> Propriétaire </th>
                                <th> Action </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var = "userName" scope ="session" value = "${pageContext.request.userPrincipal.name}"/>
                            <c:forEach items="${topos}" var="t" varStatus="status">
                                <tr>
                                    <td>${t.name}</td>
                                    <td>${t.userEscalad.userName}</td>

                                    <td>
                                        <form class="login-form" name ="f" action="${pageContext.request.contextPath}/reservetopo?userId=${currentUser.userEscaladId}&topoId=${t.topoId}" method='POST'>
                                            <c:if test="${t.userEscalad.userName != pageContext.request.userPrincipal.name}">
                                                <button  name = "submit" type="submit" class="btn btn-warning">RESERVER</button>
                                            </c:if>
                                            <c:if test="${t.userEscalad.userName eq pageContext.request.userPrincipal.name}">
                                                <button type="button" class="btn btn-secondary btn-lg" disabled>INDISPONIBLE</button>
                                            </c:if>
                                        </form>
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-center">
                                <li class="${currentPageTopo == 0 ? 'page-item disabled' : 'page-item'}">
                                    <a class="page-link" href="${pageContext.request.contextPath}/displaytopoavailable?user=${pageContext.request.userPrincipal.name}&page=${currentPageTopo-1}" tabindex="-1">Previous</a>
                                </li>
                                <c:set var="k" value="1" />
                                <c:forEach items="${arrayNbPagesTopo}" var="pageTopo" varStatus="loop">
                                    <li class="${currentPageTopo==loop.index ? 'page-item active' : 'page-item'}">
                                        <a class="page-link" href="${pageContext.request.contextPath}/displaytopoavailable?user=${pageContext.request.userPrincipal.name}&page=${loop.index}">${loop.index}</a>
                                    </li>
                                    <c:set var="k" value="${k+1}" />
                                </c:forEach>
                                <li class="${currentPageTopo >= nbPagesTopo-1 ? 'page-item disabled' : 'page-item'}">
                                    <a class="page-link" href="${pageContext.request.contextPath}/displaytopoavailable?user=${pageContext.request.userPrincipal.name}&page=${currentPageTopo+1}">Next</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
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
