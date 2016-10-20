<%@page import="com.jorypestorious.jsplabs.Controller"%>
<%@page import="com.jorypestorious.jsplabs.dto.Lucky7Report"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="report" class="com.jorypestorious.jsplabs.dto.Lucky7Report" scope="page"/>
<jsp:setProperty name="report" property="initialValue"/> 
<%Controller.playLucky7s(report);%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky 7's</title>
        <style>
            .center {
                margin: 0 auto;  
                max-width: 200px;
            }
        </style>
    </head>
    <body>
        <div class="center">
            
            <h1>Lucky 7's</h1>
        
            <p><b>Initial Bet: </b><%= report.getInitialValue()%></p>
            <p><b>Max Money: </b><%= report.getMaxValue()%></p>
            <p><b>Round # at Max: </b><%= report.getMaxTurn()%></p>
            <p><b>Round # at 0: </b><%= report.getTotalTurns()%></p>
        
        </div>
        
    </body>
</html>
