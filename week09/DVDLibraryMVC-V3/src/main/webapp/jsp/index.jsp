<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/styleAjax.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/library">Library</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>

                    <li role="presentation">
                        <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
                    </li> 
                </ul>    
            </div>

            <div class="row">
                <div class="col-md-6">
                    <h2 class="text-center">^__^</h2>
                </div>

                <div class="col-md-6">
                    <h2 class="text-center">Log In</h2>
                    <%@include file="login.jsp"%>
                </div> <!-- End col div -->
            </div> <!-- End row div --> 

        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

