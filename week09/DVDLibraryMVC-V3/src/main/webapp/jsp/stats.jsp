<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>DVD Library</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/styleAjax.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">

            <p id="log-out" style="float:right;">
                <sec:authentication property="principal.username" /> | 
                <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
            </p>

            <h1>DVD Library</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                        <sec:authorize access="hasAnyRole('ROLE_USER, ROLE_ADMIN')"> 
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>
                        </sec:authorize>
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN')"> 
                        <li role="presentation"><a href="${pageContext.request.contextPath}/admin/">Admin</a></li>
                        </sec:authorize>
                </ul>    
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <h2>Library Statistics (of <b>${numOfDvds}</b> DVDs)</h2>

                    <div class="row">
                        <div class="col-sm-6">
                            <div id="mpaa-chart"></div>
                        </div> 
                        <div class="col-sm-6">
                            <div id="year-chart"></div>
                        </div> 
                    </div>

                </div> 
            </div>

        </div>

        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script>
            google.load('visualization', '1.0', {'packages': ['corechart']});
        </script> 
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/stats.js"></script> 
    </body>
</html>

