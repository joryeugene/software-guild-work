<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <sec:authorize access="hasAnyRole('ROLE_USER, ROLE_ADMIN')"> 
                <p id="log-out" style="float:right;">
                    <sec:authentication property="principal.username" /> | 
                    <a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a>
                </p>
            </sec:authorize>

            <h1>DVD Library</h1>

            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/library">Library</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>
                </ul> 

            </div>

            <div class="row">
                <div class="col-md-6">
                    <h2 class="text-center">^__^</h2>
                </div>

                <div class="col-md-6">
                    
                    <sec:authorize access="isAnonymous()">
   <!-- Content for Unauthenticated users -->  


                    <div class="form-login">
                        <form method="post" class="signin" action="j_spring_security_check">
                            <h3 id="sign-in-header">Sign In</h3>
                            <input id="username_or_email" name="j_username" type="text" class="form-control input-sm chat-input" placeholder="Username"/>
                            <br>
                            <input id="password" name="j_password" type="password" class="form-control input-sm chat-input" placeholder="Password"/>
                            <br>
                            <div class="wrapper">
                                <span class="group-btn">
                                    <button name="commit" class="btn btn-primary btn-md" type="submit">Sign In <i class="glyphicon glyphicon-log-in"></i></button>
                                </span>
                            </div>
                        </form>
                    </div>
                    <c:if test="${param.login_error == 1}">
                        <p class="validationErrors text-center" style="padding-top: 10px;">Wrong Username or Password</p>
                    </c:if>


</sec:authorize>
                </div> <!-- End col div -->
            </div> <!-- End row div --> 

        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

