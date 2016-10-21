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
            .visible {
                visibility: visible;
            }
            
            .main-select {
                width: 205px;
            }
            
            .child-select {
                width: 100px;
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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/apps/interestcalculator">Interest Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/apps/flooringcalculator">Flooring Calculator</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/apps/tipcalculator">Tip Calculator</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/apps/unitconverter">Unit Converter</a></li>
                </ul>    
            </div>
            
            <h1>Unit Converter</h1>
            
            <form method="post" action="${pageContext.request.contextPath}/apps/unitconverterresults">
                
                <select name="converter" id="converter" onchange="showCorrectSelect()"  class="main-select">
                      <option value="length" selected>Length</option>
                      <option value="temperature">Temperature</option>
                </select>
                
                <div id="length" class="visible">
                    <select name="startingUnit" class="child-select">
                          <option value="foot" selected>Foot</option>
                          <option value="yard">Yard</option>
                    </select>
                    <select name="endingUnit" class="child-select">
                          <option value="foot">Foot</option>
                          <option value="yard" selected>Yard</option>
                    </select>
                </div>
                
                <div id="temperature" class="hidden">
                    <select name="startingUnit" class="child-select">
                          <option value="celsius" selected>Celsius</option>
                          <option value="farenheit">Farenheit</option>
                    </select>
                    <select name="endingUnit" class="child-select">
                          <option value="celsius">Celsius</option>
                          <option value="farenheit" selected>Farenheit</option>
                    </select>
                </div>
                
                <p style="margin-top: 10px">Value: <input type="text" name="value" size="10"></p>
                
                <input type="submit">
            </form>
            
        </div>
        
        <footer>
            <p>Jory Pestorious 2016<br>Powered by Java and Bootstrap</p>
        </footer>
        
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script>
            var showCorrectSelect = function() {
                var converter = document.getElementById('converter');
                var type = converter.options[converter.selectedIndex].value;
                
                var length = document.getElementById('length');
                var temperature = document.getElementById('temperature');
               
                $('.child-select').attr('name', '');               
                
                length.className = 'hidden';
                temperature.className = 'hidden';
                
                switch(type) {
                    case 'length': 
                        length.className = 'visible';
                        $( '#length > select:nth-child(1)').attr('name', 'startingUnit');
                        $( '#length > select:nth-child(2)').attr('name', 'endingUnit');
                        break;
                    case 'temperature': temperature.className = "visible";
                        $( '#temperature > select:nth-child(1)').attr('name', 'startingUnit');
                        $( '#temperature > select:nth-child(2)').attr('name', 'endingUnit');
                        break;
                }
            };
        </script>
        
    </body>
</html>

