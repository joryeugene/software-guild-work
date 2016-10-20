<%@page import="com.jorypestorious.jsplabs.Controller"%>
<%@page import="com.jorypestorious.jsplabs.dto.Lucky7Report"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="report" class="com.jorypestorious.jsplabs.dto.FactorizorReport" scope="page"/>
<jsp:setProperty name="report" property="num"/> 
<%Controller.factorize(report);%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizor</title>
        <style>
            .center {
                margin: 0 auto;  
                max-width: 200px;
            }
        </style>
    </head>
    <body>
        <div class="center">
            
            <h1>Factorizor</h1>
        
            <p><b>Number: </b><%= report.getNum() %></p>
            <p><b># of Factors: </b><%= report.getFactors().size() %></p>
            <p><b>Factors: </b><%= report.getFactors() %></p>
            <p><b>Prime: </b><%= report.isPrime() %></p>
            <p><b>Perfect: </b><%= report.isPerfect() %></p>
            
        </div>
    </body>
</html>