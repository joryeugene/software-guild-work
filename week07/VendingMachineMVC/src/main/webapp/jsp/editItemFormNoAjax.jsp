<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
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
            <h2>Edit Item</h2>

            <a href="${pageContext.request.contextPath}/displayVendingMachineNoAjax">Back - Vending Machine (No Ajax)</a><br/>
            <hr/>

            <sf:form class="form-horizontal"
                  role="form"
                  modelAttribute="item"
                  action="editItemNoAjax"
                  method="POST">
                <div class="form-group">
                    <label for="edit-name"
                           class="col-md-2 control-label">Item Name:</label>
                    <div class="col-md-3">
                        <sf:input type="text"
                               class="form-control"
                               id="edit-name"
                               path="name"
                               placeholder="Item Name"/>
                        <sf:errors path="name" class="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <label for="edit-cost" class="col-md-2 control-label">Cost Per Unit:</label>
                    <div class="col-md-3">
                        <sf:input type="number" step="any"
                               class="form-control"
                               id="edit-cost"
                               path="cost"
                               placeholder="Cost Per Unit"/>
                        <sf:errors path="cost" class="error"></sf:errors>
                    </div>
                </div>

                <div class="form-group">
                    <label for="edit-quantity"
                           class="col-md-2 control-label">Quantity:</label>
                    <div class="col-md-3">
                        <sf:input type="number"
                               class="form-control"
                               id="edit-quantity"
                               path="count"
                               placeholder="Quantity"/>
                        <sf:errors path="count" class="error"></sf:errors>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-3">
                        <button type="submit"
                                id="add-button"
                                class="btn btn-default">Update Item</button>
                    </div>
                </div>
            </sf:form>
        </div>



        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

