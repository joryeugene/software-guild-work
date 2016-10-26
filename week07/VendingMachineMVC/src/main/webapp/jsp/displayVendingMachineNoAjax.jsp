<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
        <style>
            .error {
                color: red;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Vending Machine</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/admin/">ADMIN</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayVendingMachineNoAjax/">Vending Machine (No Ajax)</a></li>
                </ul>    
            </div>
            <h2>Items</h2>

            <a href="${pageContext.request.contextPath}/displayNewItemFormNoAjax">Add an Item</a><br/>
            <hr/>
            
            <c:forEach var="item" items="${itemList}">
                
                <s:url value="/deleteItemNoAjax"
                       var="deleteItem_url">
                    <s:param name="id" value="${item.id}" />
                </s:url>
                <s:url value="/displayEditItemFormNoAjax"
                       var="editItem_url">
                    <s:param name="id" value="${item.id}" />
                </s:url>
                <s:url value="/buyItemNoAjax"
                       var="buyItem_url">
                    <s:param name="id" value="${item.id}" />
                </s:url>
                <c:if test="${item.count < 1}">
                    <span class="error">OUT OF STOCK</span><br/>
                </c:if>
                <b>${item.name}</b> - <i><fmt:formatNumber value="${item.cost}" type="currency"/></i> - <u>Quantity:</u> ${item.count} |
                <a href="${deleteItem_url}">Delete</a> |
                <a href="${editItem_url}">Edit</a> |
                <a href="${buyItem_url}"><button>Buy</button></a><br/>
                <hr>
            </c:forEach>
        </div>



        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

