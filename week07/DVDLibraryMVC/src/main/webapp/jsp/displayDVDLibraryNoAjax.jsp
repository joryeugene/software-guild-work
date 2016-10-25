<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD Library</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
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

            <h2>DVDs</h2>
            <a href="${pageContext.request.contextPath}/displayNewDVDFormNoAjax">Add a DVD</a><br/>
            <hr/>
            
            <c:forEach var="dvd" items="${dvdList}">
                <s:url value="/deleteDVDNoAjax"
                       var="deleteDVD_url">
                    <s:param name="id" value="${dvd.id}" />
                </s:url>
                <s:url value="/displayEditDVDFormNoAjax"
                       var="editDVD_url">
                    <s:param name="id" value="${dvd.id}" />
                </s:url>
                <b>"${dvd.title}"</b> (${dvd.year}) Rated ${dvd.mpaa} |
                <a href="${deleteDVD_url}">Delete</a> |
                <a href="${editDVD_url}">Edit</a><br/>
                <i>Directed by ${dvd.director} and Produced by ${dvd.studio}</i><br/>
                <u>Note:</u> ${dvd.note}<br/>
                <hr>
            </c:forEach>

        </div>



        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

