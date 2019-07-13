<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>Login</title>
    <meta charset="utf-8">
    <spring:url value="resources/css/bootstrap.min.css" var="bootstrap" />
    <spring:url value="resources/css/loginForm.css" var="loginForm" />
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="${bootstrap}" rel="stylesheet" />
    <link href="${loginForm}" rel="stylesheet" />

</head>

<body>
<jsp:include page="../_menu.jsp" />


<div class="wrapper fadeInDown">
    <div id="formContent">
        <div class="row">
            <section class="col-xs-12">

                <!-- Register Form -->
                <form name='f' action="${pageContext.request.contextPath}/saveUser"  method='POST' modelAttribue = "user">
                    <input type="text" id="lastName" class="fadeIn second" name="lastName" placeholder="Nom" value ='' required="true"/>
                    <input type="text" id="firstName" class="fadeIn second" name="firstName" placeholder="Prénom" value ='' required="true"/>
                    <input type="text" id="userName" class="fadeIn second" name="userName" placeholder="Choisir un nom d'utilisateur" value ='' required="true"/>
                    <input type="password" id="password" class="fadeIn third" name="password" placeholder="Choisir un mot de passe" required="true"/>
                    <input type="hidden" id="enabled" name="enabled" value= ${1} />
                    <input type="submit" class="fadeIn fourth"  name="submit" value="submit">
                </form>

            </section>
        </div>
    </div>
</div>
<jsp:include page="../_footer.jsp" />
</body>
</html>
