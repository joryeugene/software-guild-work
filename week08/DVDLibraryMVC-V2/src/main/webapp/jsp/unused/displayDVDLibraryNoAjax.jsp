<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">

    </head>
    <body>
        <div class="container">
            <h1>DVD Library</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/search/">Search</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/stats/">Stats</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayDVDLibraryNoAjax/">DVD Library (No Ajax)</a></li>
                </ul>    
            </div>

            <div class="row text-center">
                <div class="col-md-8">
                    <h2>DVDs</h2>
                </div>
                <div class="col-md-4">
                    <h2>Add DVD</h2>
                </div>
            </div>

            <div class="row">
                <div class="col-md-8">
                    <table class="table">
                        <tr class="text-center">
                            <th width="22%">Title</th>
                            <th width="8%">Year</th>
                            <th width="8%">MPAA</th>
                            <th width="14%">Director</th>
                            <th width="15%">Producer</th>
                            <th width="35%" colspan="2">Note</th>
                        </tr>
                    </table>
                    <table class="table table-hover table-striped">
                        <tbody id="dvd-table">
                            <c:forEach var="dvd" items="${dvdList}">
                                <s:url value="/deleteDVDNoAjax" var="deleteDVD_url">
                                    <s:param name="id" value="${dvd.id}" />
                                </s:url>
                                <s:url value="/displayEditDVDFormNoAjax" var="editDVD_url">
                                    <s:param name="id" value="${dvd.id}" />
                                </s:url>
                                <tr>
                                    <td width="22%"><b>${dvd.title}</b></td>
                                    <td width="8%" class="text-center">${dvd.year}</td>
                                    <td width="8%" class="text-center">${dvd.mpaa}</td>
                                    <td width="14%">${dvd.director}</td>
                                    <td width="15%">${dvd.studio}</td>
                                    <td width="27%">${dvd.note}</td>
                                    <td style="float: right;">
                                        <a href="${editDVD_url}">Edit</a><br>
                                        <a href="${deleteDVD_url}">Delete</a>                                        
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-4">
                    <table class="table"><tr><th>&nbsp;</th></tr></table> <!-- just for the hr line...-->

                    <sf:form class="form-horizontal" role="form" modelAttribute="dvd"
                             action="${pageContext.request.contextPath}/addNewDVDNoAjax" method="POST">
                        <div class="form-group">
                            <label for="edit-title" class="col-md-4 control-label">Title:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" id="edit-title"
                                          path="title" placeholder="Title"/>
                                <sf:errors path="title" class="error"></sf:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="edit-year" class="col-md-4 control-label">Year:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" id="edit-year"
                                          path="year" placeholder="Year"/>
                                <sf:errors path="year" class="error"></sf:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="edit-mpaa" class="col-md-4 control-label">MPAA Rating:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" id="edit-mpaa"
                                          path="mpaa" placeholder="MPAA Rating"/>
                                <sf:errors path="mpaa" class="error"></sf:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="edit-director" class="col-md-4 control-label">Director:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" id="edit-director"
                                          path="director" placeholder="Director"/>
                                <sf:errors path="director" class="error"></sf:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="edit-studio" class="col-md-4 control-label">Studio:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" id="edit-studio"
                                          path="studio" placeholder="Studio"/>
                                <sf:errors path="studio" class="error"></sf:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="edit-note" class="col-md-4 control-label">Note:</label>
                            <div class="col-md-8">
                                <sf:textarea type="text" class="form-control" id="edit-note"
                                          path="note" placeholder="Note"/>
                                <sf:errors path="note" class="error"></sf:errors>
                                <sf:hidden path="id"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" id="add-button" class="btn btn-default">Add DVD</button>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>

        </div>
                
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script>
            $('#dvd-table').scroll(function () {
                sessionStorage.scrollTop = $(this).scrollTop();
            });

            $(document).ready(function () {
                if (sessionStorage.scrollTop != "undefined") {
                    $('#dvd-table').scrollTop(sessionStorage.scrollTop);
                }
            });
        </script>
    </body>
</html>

