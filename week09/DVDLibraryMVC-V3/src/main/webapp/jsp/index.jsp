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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search/">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>
                </ul>    
            </div>

            <div class="row">
                <div class="col-md-8">
                    <h2 class="text-center">DVDs</h2>                    
                    <section id="dvd-table" class="row text-center"></section>
                </div>

                <div class="col-md-4">
                    <h2 class="text-center">Add New DVD</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="add-title" class="col-md-3 control-label">
                                Title:
                            </label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="add-title"
                                       placeholder="Title"/>
                                <div id="error-title" class="validationErrors"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-year" class="col-md-3 control-label">
                                Year:
                            </label>
                            <div class="col-md-9">
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
                            <label for="add-mpaa" class="col-md-3 control-label">
                                MPAA Rating:
                            </label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="add-mpaa"
                                       placeholder="MPAA"/>
                                <div id="error-mpaa" class="validationErrors"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-director" class="col-md-3 control-label">Director:</label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="add-director"
                                       placeholder="Director"/>
                                <div id="error-director" class="validationErrors"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-studio" class="col-md-3 control-label">Studio:</label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="add-studio"
                                       placeholder="Studio"/>
                                <div id="error-studio" class="validationErrors"></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-note" class="col-md-3 control-label">Note:</label>
                            <div class="col-md-9">
                                <textarea class="form-control" id="add-note" placeholder="Note"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit"
                                        id="add-button"
                                        class="btn btn-default">
                                    Add
                                </button>
                            </div>
                        </div>
                    </form>
                </div> <!-- End col div -->
            </div> <!-- End row div --> 
        </div>

        <%@include file="detailsEditModalFragment.jsp"%>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdLibrary.js"></script>
    </body>
</html>

