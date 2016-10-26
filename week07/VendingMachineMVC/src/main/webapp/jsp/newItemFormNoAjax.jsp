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
            <h2>New Item Form</h2>

            <a href="${pageContext.request.contextPath}/displayVendingMachineNoAjax">Back - Vending Machine (No Ajax)</a><br/>
            <hr/>

            <form class="form-horizontal"
                  role="form"
                  action="addNewItemNoAjax"
                  method="POST">
                <div class="form-group">
                    <label for="add-name"
                           class="col-md-4 control-label">Item Name:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="add-name"
                               name="name"
                               placeholder="Item Name"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-cost" class="col-md-4 control-label">Cost Per Unit:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="add-cost"
                               name="cost"
                               placeholder="Cost Per Unit"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="add-quantity"
                           class="col-md-4 control-label">Quantity:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="add-quantity"
                               name="count"
                               placeholder="Quantity"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type="submit"
                                id="add-button"
                                class="btn btn-default">Add New Item</button>
                    </div>
                </div>
            </form>
        </div>



        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

