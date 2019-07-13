<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Les topos</title>
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
        #marge{
            margin-top: 2em;
            margin-bottom: 2em;
        }
        container{
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
<section id="marge">
    <div class="container rounded border border-dark">
        <div class="text-center">
            <header class="page-header">
                <h1>Les topos du coin</h1>
            </header>
            <div>
                <p class="text-justify text-center"> Je suis passionné par <strong>l'escalade</strong> depuis très longtemps. Ce site a été construit <em>  pour les grimpeurs...</em><br>
                    Vous trouverez sur ce site des topos d'escalade pouvant être réservés par les membres enregistrés.
                </p>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class ="row justify-content-center align-content-center">
                        <section class = "col-sm-8">
                            <form class = "well">
                                <h4>Souhaitez-vous ajouter votre propre Topo ?</h4>
                                <fieldset>
                                    <a href="${pageContext.request.contextPath}/atopo?user=${pageContext.request.userPrincipal.name}" class="btn btn-primary js-scroll-trigger">Afficher le formulaire</a>
                                </fieldset>
                            </form>
                        </section>
                    </div>
                    <table class="table table-bordered table-striped table-condensed">
                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Propriétaire</th>
                            <th>Descriptif PDF du Topo</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="i" value="1" />
                        <c:forEach items="${topos}" var="t">
                            <c:set var="maVariable1" value="0" scope="page" />
                            <tr>
                                <td><a class="nav-link" href="${pageContext.request.contextPath}/sites?topoId=${t.topoId}&user=${pageContext.request.userPrincipal.name}">${t.name}</a></td>
                                <td>${t.userEscalad.userName}</td>
                                <c:forEach items="${defineDownload}" var="test" varStatus="loop">
                                    <c:if test="${defineDownload[loop.index] == t.topoId }">
                                        <td>
                                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/download?topoId=${t.topoId}" role="button">Télécharger
                                                <i class="fa fa-file" style="font-size:25px;color:red"></i>
                                            </a>
                                        </td>
                                        <c:set var="maVariable1" value="${maVariable1+1}" scope="page" />
                                    </c:if>
                                </c:forEach>
                                <c:if test="${maVariable1 != 1}">
                                    <td></td>
                                </c:if>
                            </tr>
                            <c:set var="i" value="${i+1}" />
                        </c:forEach>
                        </tbody>
                    </table>

                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="${currentPageTopo == 0 ? 'page-item disabled' : 'page-item'}">
                                <a class="page-link" href="${pageContext.request.contextPath}/topo?user=${pageContext.request.userPrincipal.name}&page=${currentPageTopo-1}" tabindex="-1">Previous</a>
                            </li>
                            <c:set var="k" value="1" />
                            <c:forEach items="${arrayNbPagesTopo}" var="pageTopo" varStatus="loop">
                                <li class="${currentPageTopo==loop.index ? 'page-item active' : 'page-item'}">
                                    <a class="page-link" href="${pageContext.request.contextPath}/topo?user=${pageContext.request.userPrincipal.name}&page=${loop.index}">${loop.index}</a>
                                </li>
                                <c:set var="k" value="${k+1}" />
                            </c:forEach>
                            <li class="${currentPageTopo >= nbPagesTopo-1 ? 'page-item disabled' : 'page-item'}">
                                <a class="page-link" href="${pageContext.request.contextPath}/topo?user=${pageContext.request.userPrincipal.name}&page=${currentPageTopo+1}">Next</a>
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
