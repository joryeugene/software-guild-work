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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/search/">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>
                </ul>    
            </div>

            <div class="row">
                <div class="col-md-8">
                    <h2 class="text-center">Search Results</h2>
                    <%@include file="dvdSummaryTableFragment.jsp"%>
                </div>

                <div class="col-md-4">
                    <h2 class="text-center">Search</h2>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="search-title" class="col-md-3 control-label">
                                Title:
                            </label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="search-title"
                                       placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-year" class="col-md-3 control-label">
                                Year:
                            </label>
                            <div class="col-md-9">
                                <input type="number"
                                       min="1878"
                                       max="2100"
                                       class="form-control"
                                       id="search-year"
                                       placeholder="Year"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-mpaa" class="col-md-3 control-label">
                                MPAA Rating:
                            </label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="search-mpaa"
                                       placeholder="MPAA"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-director" class="col-md-3 control-label">Director:</label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="search-director"
                                       placeholder="Director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-studio" class="col-md-3 control-label">Studio:</label>
                            <div class="col-md-9">
                                <input type="text"
                                       class="form-control"
                                       id="search-studio"
                                       placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit"
                                        id="search-button"
                                        class="btn btn-default">
                                    Search
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

