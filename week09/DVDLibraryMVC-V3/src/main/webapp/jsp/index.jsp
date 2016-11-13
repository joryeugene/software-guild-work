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
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                        <sec:authorize access="hasAnyRole('ROLE_USER, ROLE_ADMIN')"> 
                        <li role="presentation"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>
                        </sec:authorize>
                        <sec:authorize access="hasAnyRole('ROLE_ADMIN')"> 
                        <li role="presentation"><a href="${pageContext.request.contextPath}/admin/">Admin</a></li>
                        </sec:authorize>
                </ul> 
            </div>

            <sec:authorize access="isAnonymous()">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-login">
                            <form method="post" class="signin" action="j_spring_security_check">
                                <h3 id="sign-in-header">Sign In</h3>
                                <input id="username_or_email" name="j_username" type="text" class="form-control input-sm chat-input" placeholder="Username"/>
                                <br>
                                <input id="password" name="j_password" type="password" class="form-control input-sm chat-input" placeholder="Password"/>
                                <br>
                                <div class="wrapper">
                                    <span class="group-btn">
                                        <button name="commit" class="btn btn-primary btn-md" type="submit">Sign In</button>
                                    </span>
                                </div>
                            </form>
                        </div>
                        <c:if test="${param.login_error == 1}">
                            <p class="validationErrors text-center" style="padding-top: 10px;">Wrong Username or Password</p>
                        </c:if>
                    </div> <!-- End col div -->
                </div> <!-- End row div --> 
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ROLE_USER, ROLE_ADMIN')">     
                <div class="row">
                    <div class="col-sm-8">

                        <div class="row">
                            <div class="col-xs-offset-3 col-xs-6">
                                <h2 class="text-center">DVDs (<span id="num-of-dvds"></span>)</h2>
                            </div>
                            <div class="col-xs-3">
                                <p id="sort-btns" class="text-right">Sort: <a href="#" id="a-z">A~Z</a>&nbsp;|&nbsp;<a href="#" id="z-a">Z~A</a></p>
                            </div>
                        </div>

                        <section id="dvd-table" class="row text-center"></section>
                    </div>

                    <div class="col-sm-4">
                        <h2 class="text-center col-md-offset-3 col-md-9">
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a id="add-form-toggle" href="#">Add</a> | <a id="search-form-toggle" href="#">
                                </sec:authorize>
                                Search
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                </a>
                            </sec:authorize>
                        </h2>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <form id="add-form" class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="add-title" class="col-xs-3 control-label">
                                        Title:
                                    </label>
                                    <div class="col-xs-9">
                                        <input type="text"
                                               class="form-control"
                                               id="add-title"
                                               placeholder="Title"/>
                                        <div id="error-title" class="validationErrors"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-year" class="col-xs-3 control-label">
                                        Year:
                                    </label>
                                    <div class="col-xs-9">
                                        <input type="number"
                                               min="1878"
                                               max="2100"
                                               class="form-control"
                                               id="add-year"
                                               placeholder="Year"/>
                                        <div id="error-year" class="validationErrors"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-mpaa" class="col-xs-3 control-label">
                                        MPAA Rating:
                                    </label>
                                    <div class="col-xs-9">
                                        <input type="text"
                                               class="form-control"
                                               id="add-mpaa"
                                               placeholder="MPAA"/>
                                        <div id="error-mpaa" class="validationErrors"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-director" class="col-xs-3 control-label">Director:</label>
                                    <div class="col-xs-9">
                                        <input type="text"
                                               class="form-control"
                                               id="add-director"
                                               placeholder="Director"/>
                                        <div id="error-director" class="validationErrors"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-studio" class="col-xs-3 control-label">Studio:</label>
                                    <div class="col-xs-9">
                                        <input type="text"
                                               class="form-control"
                                               id="add-studio"
                                               placeholder="Studio"/>
                                        <div id="error-studio" class="validationErrors"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="add-note" class="col-xs-3 control-label">Note:</label>
                                    <div class="col-xs-9">
                                        <textarea class="form-control" id="add-note" placeholder="Note"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-xs-offset-3 col-xs-9">
                                        <button type="submit"
                                                id="add-button"
                                                class="btn btn-primary">
                                            Add
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </sec:authorize>

                        <form id="search-form" class="hidden form-horizontal" role="form">
                            <div class="form-group">
                                <label for="search-title" class="col-xs-3 control-label">
                                    Title:
                                </label>
                                <div class="col-xs-9">
                                    <input type="text"
                                           class="form-control"
                                           id="search-title"
                                           placeholder="Title"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="search-year" class="col-xs-3 control-label">
                                    Year:
                                </label>
                                <div class="col-xs-9">
                                    <input type="number"
                                           min="1878"
                                           max="2100"
                                           class="form-control"
                                           id="search-year"
                                           placeholder="Year"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="search-mpaa" class="col-xs-3 control-label">
                                    MPAA Rating:
                                </label>
                                <div class="col-xs-9">
                                    <input type="text"
                                           class="form-control"
                                           id="search-mpaa"
                                           placeholder="MPAA"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="search-director" class="col-xs-3 control-label">Director:</label>
                                <div class="col-xs-9">
                                    <input type="text"
                                           class="form-control"
                                           id="search-director"
                                           placeholder="Director"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="search-studio" class="col-xs-3 control-label">Studio:</label>
                                <div class="col-xs-9">
                                    <input type="text"
                                           class="form-control"
                                           id="search-studio"
                                           placeholder="Studio"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-offset-3 col-xs-9">
                                    <button type="submit"
                                            id="search-button"
                                            class="btn btn-primary">
                                        Search
                                    </button>
                                </div>
                            </div>
                        </form>


                    </div> <!-- End col div -->
                </div> <!-- End row div --> 
            </div>

            <%@include file="detailsEditModalFragment.jsp"%>
        </sec:authorize>

    </div>

    <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <sec:authorize access="hasAnyRole('ROLE_USER')"> 
        <script src="${pageContext.request.contextPath}/js/dvdLibrary.js"></script>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_ADMIN')"> 
        <script src="${pageContext.request.contextPath}/js/dvdLibraryAdmin.js"></script>
    </sec:authorize>
</body>
</html>