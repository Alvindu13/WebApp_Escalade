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
            <h3>Entrez votre pseudo et votre mot de passe:</h3>
            <!-- /login?error=true -->
            <c:if test="${param.error == 'true'}">
                <div style="color:red;margin:10px 0px;">
                    Les données entrées sont incorrectes!!!<br />
                </div>
            </c:if>
            <div class="row">
                <section class="col-xs-12">
                    <!-- Login Form -->
                    <form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
                        <input type="text" id="login" class="fadeIn second" name="username" placeholder="username" value ='' required="true"/>
                        <input type="password" id="password" class="fadeIn third" name="password" placeholder="password" required="true"/>
                        <input type="submit" class="fadeIn fourth"  name="submit" value="submit">
                    </form>
                </section>
            </div>
        </div>
    </div>
<jsp:include page="../_footer.jsp" />
</body>
</html>