<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Site Lab</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
        <style>
            td, th {
                text-align: center;
                padding: 5px;
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <header>
                <h1>The Software Guild Java Cohort<br>JSP Site Lab</h1>
            </header>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/apps/luckysevens">Lucky Sevens</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/apps/factorizor">Factorizor</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/apps/interestcalculator">Interest Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/apps/flooringcalculator">Flooring Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/apps/tipcalculator">Tip Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/apps/unitconverter">Unit Converter</a></li>
                </ul>    
            </div>
            
            <h1>Interest Calculator</h1>
            
            <table>
                <tr>
                    <th>Year</th>
                    <th>Principal</th>
                    <th>Interest</th>
                    <th>Year-End Principal</th>
                </tr>
                <c:forEach var="report" items="${report.annualInterestReports}">
                    <tr>
                        <td><c:out value="${report.year}"/></td>
                        <td><c:out value="${report.startingPrincipal}"/></td>
                        <td><c:out value="${report.interest}"/></td>
                        <td><c:out value="${report.endingPrincipal}"/></td>
                    </tr>
                </c:forEach>
            </table>      
            <br>
            <a href="${pageContext.request.contextPath}/apps/interestcalculator"><button>Again</button></a>
            
        </div>
        
        <footer>
            <p>Jory Pestorious 2016<br>Powered by Java and Bootstrap</p>
        </footer>
        
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        
    </body>
</html>

