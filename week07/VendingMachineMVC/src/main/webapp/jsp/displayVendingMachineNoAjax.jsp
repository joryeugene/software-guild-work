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
    <body>
        <div class="container">
            <h1>Vending Machine</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/admin/">ADMIN</a></li>
                    <li role="presentation" class="active">
                        <a href="${pageContext.request.contextPath}/displayVendingMachineNoAjax/">Vending Machine (No Ajax)</a></li>
                </ul>    
            </div>

            <div class="row">
                <div class="row">
                    <div class="col-md-4">
                        <h2>Admin & User Mode</h2>
                    </div>
                    <div class="col-md-4 text-center">
                        <c:if test="${notEnoughMoney}">
                            <p style="margin-top:20px; font-size: 1.4em" class="error">ADD MORE MONEY</p>
                        </c:if>
                    </div>
                </div>

                <hr class="hr">

                <div class="col-md-4 text-center">
                    <h2>Current Money: </h2> 
                    <p class="money-amount"><fmt:formatNumber value="${money.amount}" type="currency"/></p>
                    <form class="form-inline" role="form" action="${pageContext.request.contextPath}/addMoneyNoAjax" method="POST">
                        <input class="form-control"  type="number" step="any" min="0.01" name="amount" value="1.00" placeholder="1.00"/>
                        <button type="submit" id="add-button" class="btn btn-default">Add Money</button>
                    </form>

                    <hr>
                    
                    <div id="bought-items-div">
                        <!-- list of bought items -->
                        <c:if test="${boughtList.size() > 0}">
                            <h3>Bought Items:</h3>
                            <div id="bought-items" class="drop-shadow lifted rotated">
                                <c:forEach var="bought" items="${boughtList}">
                                    <b>${bought.name}</b> - <u>Quantity:</u> ${bought.count}<br>
                                    </c:forEach>
                            </div>
                        </c:if>
                    </div>
                </div>

                <div class="col-md-4">
                    <div id="vending-machine" class="drop-shadow lifted">
                        <p class="text-center">ITEMS</p>
                        <div id="items-div" class="bevel">
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
                                <b>${item.name}</b> - <i>
                                    <fmt:formatNumber value="${item.cost}" type="currency"/></i> - <u>Quantity:</u> ${item.count}<br>
                                <a href="${deleteItem_url}">Delete</a> | <a href="${editItem_url}">Edit</a>
                                <a href="${buyItem_url}"><button class="buy-btn">Buy</button></a><br/>
                                <hr>
                            </c:forEach>
                        </div>
                    </div>
                </div>

                <div class="clearfix visible-xs visible-sm"></div>

                <div class="col-md-4">
                    <h2 class="text-center">Add Item</h2>
                    <sf:form class="form-horizontal" role="form" modelAttribute="item"
                             action="${pageContext.request.contextPath}/addNewItemNoAjax" method="POST">
                        <div class="form-group">
                            <label for="add-name" class="col-sm-4 control-label">Item Name:</label>
                            <div class="col-sm-8">
                                <sf:input type="text" class="form-control" id="add-name" path="name" placeholder="Item Name"/>
                                <sf:errors path="name" class="error"></sf:errors>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-cost" class="col-sm-4 control-label">Cost Per Unit:</label>
                                <div class="col-sm-8">
                                <sf:input type="number" step="any" class="form-control" id="add-cost" path="cost" placeholder="Cost Per Unit"/>
                                <sf:errors path="cost" class="error"></sf:errors>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="add-quantity" class="col-sm-4 control-label">Quantity:</label>
                                <div class="col-sm-8">
                                <sf:input type="number" class="form-control" id="add-quantity" path="count" placeholder="Quantity"/>
                                <sf:errors path="count" class="error"></sf:errors>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-4 col-sm-8">
                                    <button type="submit" id="add-button" class="btn btn-default">Add New Item</button>
                                </div>
                            </div>
                    </sf:form>
                </div>

            </div> <!-- main row -->
        </div>

        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script>
            $('#items-div').scroll(function () {
                sessionStorage.scrollTop = $(this).scrollTop();
            });

            $(document).ready(function () {
                if (sessionStorage.scrollTop != "undefined") {
                    $('#items-div').scrollTop(sessionStorage.scrollTop);
                }
            });
        </script>
    </body>
</html>

