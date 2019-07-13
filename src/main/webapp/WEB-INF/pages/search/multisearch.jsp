<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recherche</title>
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
        <div class="card">
            <div class="card-header">
                <div class="card">
                    <div class="card-header">
                        Recherche ton site de grimpe
                    </div>
                    <div class="card-body">
                        <form class="login-form" name ="f" action="multisearch" method='POST' modelAttribute="searcher">
                            <div class = row >
                                <div class="form-group col-md-5">
                                    <label for="inputState">Lieu</label>
                                    <select id="inputState" class="form-control" name = 'location' required = 'true'>
                                        <option selected>Choose...</option>
                                        <c:forEach items="${sites}" var="site" varStatus="status">
                                            <option>${sites[status.index]}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-3">
                                    <label for="inputState">Cotation Minimum</label>
                                    <select id="inputState2" class="form-control" name = 'cotationMinimum' required = 'true'>
                                        <option selected>Choose...</option>
                                        <option>4A</option>
                                        <option>4B</option>
                                        <option>4C</option>
                                        <option>4D</option>
                                        <option>4E</option>
                                        <option>5A</option>
                                        <option>5B</option>
                                        <option>5C</option>
                                    </select>
                                </div>

                                <div class="form-group col-md-3">
                                    <label for="inputState">Cotation Maximum</label>
                                    <select id="inputState5" class="form-control" name = 'cotationMaximum' required = 'true'>
                                        <option selected>Choose...</option>
                                        <option>4A</option>
                                        <option>4B</option>
                                        <option>4C</option>
                                        <option>4D</option>
                                        <option>4E</option>
                                        <option>5A</option>
                                        <option>5B</option>
                                        <option>5C</option>
                                        <option>6A</option>
                                        <option>6B</option>
                                        <option>6C</option>
                                        <option>7A</option>
                                        <option>7B</option>
                                        <option>7C</option>
                                        <option>7D</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<div class = "test">
    <jsp:include page="../_footer.jsp" />
</div>
</body>
</html>

