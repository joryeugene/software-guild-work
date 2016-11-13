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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                        <sec:authorize access="hasAnyRole('ROLE_USER, ROLE_ADMIN')"> 
                        <li role="presentation"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>
                        </sec:authorize>
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN')"> 
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/admin/">Admin</a></li>
                        </sec:authorize>
                </ul> 
            </div>

            <div class="row">
                <div class="col-sm-7">
                    <h2 class="text-center">Users</h2>

                    <table id="users-table" class="table table-hover table-responsive">
                        <tr>
                            <th>Username</th>
                            <th>Role</th>
                            <th></th>
                        </tr>

                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td><c:out value="${user.username}"/></td>
                                    <td><c:out value="${user.authorities[0]}"/></td>
                                    <td><a href="${pageContext.request.contextPath}/deleteUser?username=${user.username}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>

                </div>

                <div class="col-sm-4">
                    <h2 class="text-center">Add User</h2>

                    <form id="user-form" class="form-horizontal" role="form" method="POST" action="${pageContext.request.contextPath}/addUser">
                        <div class="form-group">
                            <label for="user-form-username" class="col-xs-4 control-label text-right">
                                Username:
                            </label>
                            <div class="col-xs-8">
                                <input type="text"
                                       class="form-control"
                                       id="user-form-username"
                                       placeholder="Username"
                                       name="username"
                                       style="max-width:300px;"/>
                                <c:if test="${unError}">
                                    <p class="validationErrors">Invalid Username</p>
                                </c:if>
                                <c:if test="${unAlreadyUsed}">
                                    <p class="validationErrors">Username Taken</p>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="user-form-password" class="col-xs-4 control-label text-right">
                                Password:
                            </label>
                            <div class="col-xs-8">
                                <input type="password"
                                       class="form-control"
                                       id="user-form-password"
                                       placeholder="Password"
                                       name="password"
                                       style="max-width:300px;"/>
                                <c:if test="${pwError}">
                                    <p class="validationErrors">Invalid Password</p>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-offset-3 col-xs-5  text-right">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="isAdmin" value="yes"> Admin User
                                    </label>
                                </div>
                            </div>
                            <div class="col-xs-4  text-center">
                                <button type="submit" class="btn btn-primary">
                                    Add
                                </button>
                            </div>
                        </div>
                    </form>
                </div> <!-- End col div -->

            </div> <!-- End row div --> 

        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>