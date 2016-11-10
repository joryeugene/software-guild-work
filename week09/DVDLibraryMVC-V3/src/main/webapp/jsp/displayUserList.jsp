<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                        <sec:authorize access="hasAnyRole('ROLE_USER, ROLE_ADMIN')"> 
                        <li role="presentation"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>
                        </sec:authorize>
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN')"> 
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayUserList/">Admin</a></li>
                        </sec:authorize>
                </ul> 
            </div>

            <div class="row">
                <div class="col-sm-7">
                    <h2 class="text-center">Users</h2>

                    <table id="users-table" class="table table-hover">
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
                                    <td><a href="deleteUser?username=${user.username}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>

                </div>

                <div class="col-sm-4">
                    <h2 class="text-center">Add User</h2>

                    <form id="user-form" class="form-horizontal" role="form" method="POST" action="/Library/addUser">
                        <div class="form-group">
                            <label for="user-form-username" class="col-md-3 control-label">
                                Username:
                            </label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="user-form-username"
                                       placeholder="Username"
                                       name="username"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="user-form-password" class="col-md-3 control-label">
                                Password:
                            </label>
                            <div class="col-md-9">
                                <input type="password"
                                       class="form-control"
                                       id="user-form-password"
                                       placeholder="Password"
                                       name="password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-9">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="isAdmin" value="yes"> Admin User
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-9">
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