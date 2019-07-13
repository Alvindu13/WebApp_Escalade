<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Fiche du site</title>
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

        <!--Containeur-->
        <section class = "marge">
            <div class="container rounded border border-dark">
                <div class="text-center">
                    <br>
                    <h1 style = color:red >Fiche descriptive du site <c:out value = "${site.name}" /></h1>
                    <div>
                        <div class="row text-left">
                            <section class="col-sm-12">
                                <p>Vous êtes sur la fiche d'information du Site d'escalade : <strong> ${site.name} </strong> </p>
                                <p> Ce site se situe a : <strong> ${site.location} </strong> </p>
                                <p>Descriptif du site :<strong> ${site.comment} </strong> </p>
                                <p>Le site dispose de :
                                    <a class="nav-link" href="${pageContext.request.contextPath}/sector?siteId=${site.siteId}">
                                        <strong> ${countSect} </strong> secteurs
                                    </a>
                            </section>
                        </div>
                    </div>

                    <!--Comment-->
                    <section>
                        <div class="row text-left">
                            <section class="col-sm-9">
                                <div class="commentaire">
                                    <div class="form">
                                        <h4>Écrivez votre commentaire : </h4>
                                        <c:set var="name" value="${pageContext.request.userPrincipal.name}" scope="request" />

                                        <form class="login-form" name ="f" action="addcmt" method='POST' modelAttribute="commentaire">
                                            <div class="form-group">
                                                <label for="comment">Description:</label>
                                                <textarea class="form-control" rows="5" id="comment" placeholder='' name='content' ></textarea>
                                            </div>
                                            <input type='hidden' placeholder='' name='userName' class="form-control" id="username" value="${pageContext.request.userPrincipal.name}"/>
                                            <input type='hidden' placeholder='' name='userEscaladId' class="form-control" id="user" value="${user.userEscaladId}"/>
                                            <input type="hidden" id="siteId" name="siteId" value="${site.siteId}"/>
                                            <button type="submit" class="btn btn-primary">Ajouter votre commentaire</button>
                                        </form>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </section>


                    <div class="panel-body">
                        <table class="table table-bordered table-striped table-condensed">
                            <thead>
                            <tr>
                                <th>Commentaires</th>
                                <th>Auteur</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="i" value="1" />
                            <c:forEach items="${cmt}" var="c">
                                <tr>
                                    <td>${c.content}</td>
                                    <td>${c.userName}</td>
                                </tr>
                                <c:set var="i" value="${i+1}" />
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>


                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="${currentPage == 0 ? 'page-item disabled' : 'page-item'}">
                                <a class="page-link" href="${pageContext.request.contextPath}/site?siteId=${site.siteId}&user=${pageContext.request.userPrincipal.name}&page=${currentPage-1}" tabindex="-1">Previous</a>
                            </li>
                            <c:set var="k" value="1" />
                            <c:forEach items="${pages}" var="pageTopo" varStatus="loop">
                                <li class="${currentPage==loop.index ? 'page-item active' : 'page-item'}">
                                    <a class="page-link" href="${pageContext.request.contextPath}/site?siteId=${site.siteId}&user=${pageContext.request.userPrincipal.name}&page=${loop.index}">${loop.index}</a>
                                </li>
                                <c:set var="k" value="${k+1}" />
                            </c:forEach>
                            <li class="${currentPage >= nbPagesCmt-1 ? 'page-item disabled' : 'page-item'}">
                                <a class="page-link" href="${pageContext.request.contextPath}/site?siteId=${site.siteId}&user=${pageContext.request.userPrincipal.name}&page=${currentPage+1}">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </section>

        <div>
            <jsp:include page="../_footer.jsp" />
        </div>
    </body>
</html>
